package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.h2.util.StringUtils;
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

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private FacebookAuthenticationService facebookAuthenticationService;

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private FacebookUserRepository facebookUserRepository;

	@Override
	public AmityUser authenticateAmityUser(long amityUserId, AmityToken authToken) {
		AmityUserEntity entity = amityUserRepository.getOne(amityUserId);
		if (entity != null && StringUtils.equals(authToken.getValue(), entity.getAuthToken())) {
			return new AmityUser(entity);
		}

		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AmityUser authenticateFacebookAccount(String facebookToken) {
		FacebookUserInfo facebookUserInfo = facebookAuthenticationService.getUserInfo(facebookToken);
		if (facebookUserInfo == null) {
			return null;
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

			return new AmityUser(amityUserEntity);
		} else {
			return new AmityUser(facebookUserRepository.getOne(facebookUserInfo.getId()).getAmityUser());
		}
	}
}
