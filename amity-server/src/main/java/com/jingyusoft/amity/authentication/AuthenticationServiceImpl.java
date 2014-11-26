package com.jingyusoft.amity.authentication;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.facebook.FacebookAuthenticationService;
import com.jingyusoft.amity.authentication.facebook.FacebookUserInfo;
import com.jingyusoft.amity.dao.AmityUserDao;
import com.jingyusoft.amity.dao.FacebookUserDao;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.data.entities.FacebookUserEntity;
import com.jingyusoft.amity.domain.AmityUser;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private FacebookAuthenticationService facebookAuthenticationService;

	@Resource
	private AmityUserDao amityUserDao;

	@Resource
	private FacebookUserDao facebookUserDao;

	@Override
	public AmityUser authenticateFacebookAccount(String facebookToken) {
		FacebookUserInfo facebookUserInfo = facebookAuthenticationService.getUserInfo(facebookToken);
		if (facebookUserInfo == null) {
			return null;
		}

		FacebookUserEntity facebookUserEntity = facebookUserDao.get(facebookUserInfo.getId());
		if (facebookUserEntity == null) {
			AmityUserEntity amityUserEntity = new AmityUserEntity();
			amityUserEntity.setEmailAddress(facebookUserInfo.getEmail());
			amityUserEntity.setFirstName(facebookUserInfo.getFirstName());
			amityUserEntity.setLastName(facebookUserInfo.getLastName());
			amityUserEntity.setGender(facebookUserInfo.getGender());
			amityUserEntity.setAlias(facebookUserInfo.getName());

			amityUserEntity.setAuthToken(AuthenticationUtils.generateAuthToken(facebookToken));

			amityUserEntity = amityUserDao.merge(amityUserEntity);

			facebookUserEntity = new FacebookUserEntity();
			facebookUserEntity.setFacebookId(facebookUserInfo.getId());
			facebookUserEntity.setAmityUser(amityUserEntity);
			facebookUserDao.merge(facebookUserEntity);

			return new AmityUser(amityUserEntity);
		} else {
			return new AmityUser(facebookUserEntity.getAmityUser());
		}
	}
}
