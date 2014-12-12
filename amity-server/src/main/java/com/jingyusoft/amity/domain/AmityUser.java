package com.jingyusoft.amity.domain;

import org.joda.time.DateTime;

import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.thrift.generated.AmityUserDto;

public class AmityUser {

	private final AmityUserEntity entity;

	public AmityUser(AmityUserEntity entity) {
		this.entity = entity;
	}

	public String getAlias() {
		return entity.getAlias();
	}

	public final AmityUserType getAmityUserType() {
		return AmityUserType.from(entity.getUserType());
	}

	public String getAuthToken() {
		return entity.getAuthToken();
	}

	public String getAvatar() {
		return entity.getAvatar();
	}

	public String getEmailAddress() {
		return entity.getEmailAddress();
	}

	public String getEncryptedPassword() {
		return entity.getEncryptedPassword();
	}

	public String getFirstName() {
		return entity.getFirstName();
	}

	public Gender getGender() {
		return Gender.parse(entity.getGender());
	}

	public long getId() {
		return entity.getId();
	}

	public DateTime getLastLoginDateTime() {
		return entity.getLastLoginDateTime();
	}

	public String getLastName() {
		return entity.getLastName();
	}

	public String getPasswordSand() {
		return entity.getPasswordSand();
	}

	public DateTime getRegisterDateTime() {
		return entity.getRegisterDateTime();
	}

	public String getUserName() {
		return entity.getUserName();
	}

	public String getUserType() {
		return entity.getUserType();
	}

	public boolean isActive() {
		return entity.isActive();
	}

	public void setActive(boolean isActive) {
		entity.setActive(isActive);
	}

	public void setAlias(String alias) {
		entity.setAlias(alias);
	}

	public void setAuthToken(String authToken) {
		entity.setAuthToken(authToken);
	}

	public void setAvatar(String avatar) {
		entity.setAvatar(avatar);
	}

	public void setEmailAddress(String emailAddress) {
		entity.setEmailAddress(emailAddress);
	}

	public void setFirstName(String firstName) {
		entity.setFirstName(firstName);
	}

	public void setGender(Gender gender) {
		entity.setGender(gender.getCode());
	}

	public void setLastLoginDateTime(DateTime lastLoginDateTime) {
		entity.setLastLoginDateTime(lastLoginDateTime);
	}

	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}

	public void setPasswordSand(String passwordSand) {
		entity.setPasswordSand(passwordSand);
	}

	public void setRegisterDateTime(DateTime registerDateTime) {
		entity.setRegisterDateTime(registerDateTime);
	}

	public void setUserName(String userName) {
		entity.setUserName(userName);
	}

	public void setUserType(String userType) {
		entity.setUserType(userType);
	}

	public AmityUserDto toDto() {
		AmityUserDto amityUserDto = new AmityUserDto();
		amityUserDto.setAmityUserId(getId());
		amityUserDto.setUserType(getUserType());
		amityUserDto.setUsername(getUserName());
		amityUserDto.setFirstName(getFirstName());
		amityUserDto.setLastName(getLastName());
		amityUserDto.setEmailAddress(getEmailAddress());
		amityUserDto.setGender(getGender().getCode());
		amityUserDto.setUserAlias(getAlias());
		return amityUserDto;
	}

	public AmityUserEntity toEntity() {
		return entity;
	}
}
