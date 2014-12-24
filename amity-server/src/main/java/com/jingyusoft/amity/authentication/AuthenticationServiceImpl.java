package com.jingyusoft.amity.authentication;

import java.util.Optional;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyusoft.amity.authentication.facebook.FacebookAuthenticationService;
import com.jingyusoft.amity.authentication.facebook.FacebookUserInfo;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.data.entities.FacebookUserEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.data.repositories.FacebookUserRepository;
import com.jingyusoft.amity.domain.AmityUser;
import com.jingyusoft.amity.domain.AmityUserType;
import com.jingyusoft.amity.domain.Gender;
import com.jingyusoft.amity.thrift.generated.AmityToken;
import com.jingyusoft.amity.users.UserAccountService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private FacebookAuthenticationService facebookAuthenticationService;

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private FacebookUserRepository facebookUserRepository;

	@Resource
	private UserAccountService userAccountService;

	@Override
	public AmityUserAuthenticationResult amityUserLogin(String emailAddress, String plainPassword) {
		Optional<AmityUser> amityUserOptional = userAccountService.getAmityUserByEmail(emailAddress);
		if (amityUserOptional.isPresent()) {
			AmityUser amityUser = amityUserOptional.get();
			if (StringUtils.equals(amityUser.getEncryptedPassword(),
					AuthenticationUtils.encryptPassword(plainPassword, amityUser.getPasswordSand()))) {
				return AmityUserAuthenticationResult.success(amityUser);
			} else {
				return AmityUserAuthenticationResult.fail(AuthenticationResult.PASSWORD_INCORRECT);
			}
		} else {
			return AmityUserAuthenticationResult.fail(AuthenticationResult.EMAIL_ADDRESS_NOT_FOUND);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AmityUserAuthenticationResult authenticateAmityUser(long amityUserId, AmityToken authToken) {
		AmityUserEntity entity = amityUserRepository.getOne(amityUserId);
		if (entity != null && StringUtils.equals(authToken.getValue(), entity.getAuthToken())) {
			entity.setLastLoginDateTime(DateTime.now());
			amityUserRepository.saveAndFlush(entity);
			return AmityUserAuthenticationResult.success(new AmityUser(entity));
		}

		return AmityUserAuthenticationResult.fail(AuthenticationResult.USER_ID_NOT_FOUND);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AmityUserAuthenticationResult authenticateFacebookAccount(String facebookToken) {
		FacebookUserInfo facebookUserInfo = facebookAuthenticationService.getUserInfo(facebookToken);
		if (facebookUserInfo == null) {
			return AmityUserAuthenticationResult.fail(AuthenticationResult.INVALID_TOKEN);
		}

		if (!facebookUserRepository.exists(facebookUserInfo.getId())) {
			AmityUserEntity amityUserEntity = new AmityUserEntity();
			amityUserEntity.setUserType(AmityUserType.FACEBOOK.getCode());
			amityUserEntity.setEmailAddress(facebookUserInfo.getEmail());
			amityUserEntity.setFirstName(facebookUserInfo.getFirstName());
			amityUserEntity.setLastName(facebookUserInfo.getLastName());
			amityUserEntity.setGender(Gender.valueOf(facebookUserInfo.getGender().toUpperCase()).getCode());
			amityUserEntity.setAlias(facebookUserInfo.getName());

			amityUserEntity.setAuthToken(AuthenticationUtils.generateAuthToken(facebookToken));

			amityUserEntity = amityUserRepository.saveAndFlush(amityUserEntity);

			FacebookUserEntity facebookUserEntity = new FacebookUserEntity();
			facebookUserEntity.setFacebookId(facebookUserInfo.getId());
			facebookUserEntity.setAmityUser(amityUserEntity);
			facebookUserRepository.saveAndFlush(facebookUserEntity);

			return AmityUserAuthenticationResult.success(new AmityUser(amityUserEntity));
		} else {
			AmityUserEntity amityUserEntity = facebookUserRepository.getOne(facebookUserInfo.getId()).getAmityUser();
			amityUserRepository.saveAndFlush(amityUserEntity);
			return AmityUserAuthenticationResult.success(new AmityUser(amityUserEntity));
		}
	}
}
