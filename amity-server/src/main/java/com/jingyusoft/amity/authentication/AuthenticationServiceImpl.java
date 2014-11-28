package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.facebook.FacebookAuthenticationService;
import com.jingyusoft.amity.authentication.facebook.FacebookUserInfo;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.data.entities.FacebookUserEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.data.repositories.FacebookUserRepository;
import com.jingyusoft.amity.domain.AmityUser;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private FacebookAuthenticationService facebookAuthenticationService;

	@Resource
	private AmityUserRepository amityUserRepository;

	@Resource
	private FacebookUserRepository facebookUserRepository;

	@Override
	public AmityUser authenticateFacebookAccount(String facebookToken) {
		FacebookUserInfo facebookUserInfo = facebookAuthenticationService.getUserInfo(facebookToken);
		if (facebookUserInfo == null) {
			return null;
		}

		FacebookUserEntity facebookUserEntity = facebookUserRepository.getOne(facebookUserInfo.getId());
		if (facebookUserEntity == null) {
			AmityUserEntity amityUserEntity = new AmityUserEntity();
			amityUserEntity.setEmailAddress(facebookUserInfo.getEmail());
			amityUserEntity.setFirstName(facebookUserInfo.getFirstName());
			amityUserEntity.setLastName(facebookUserInfo.getLastName());
			amityUserEntity.setGender(facebookUserInfo.getGender());
			amityUserEntity.setAlias(facebookUserInfo.getName());

			amityUserEntity.setAuthToken(AuthenticationUtils.generateAuthToken(facebookToken));

			amityUserEntity = amityUserRepository.saveAndFlush(amityUserEntity);

			facebookUserEntity = new FacebookUserEntity();
			facebookUserEntity.setFacebookId(facebookUserInfo.getId());
			facebookUserEntity.setAmityUser(amityUserEntity);
			facebookUserRepository.saveAndFlush(facebookUserEntity);

			return new AmityUser(amityUserEntity);
		} else {
			return new AmityUser(facebookUserEntity.getAmityUser());
		}
	}
}
