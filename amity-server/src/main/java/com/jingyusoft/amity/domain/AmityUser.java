package com.jingyusoft.amity.domain;

import org.joda.time.DateTime;

import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.thrift.generated.AmityUserDto;

public class AmityUser {

	private final Long id;
	private String userName;
	private String encryptedPassword;
	private String passwordSand;
	private String authToken;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Gender gender;
	private String alias;
	private String avatar;
	private final DateTime registerDateTime;
	private final DateTime lastLoginDateTime;
	private boolean isActive;
	private AmityUserType userType;

	public AmityUser(AmityUserEntity entity) {
		id = entity.getId();
		userName = entity.getUserName();
		encryptedPassword = entity.getEncryptedPassword();
		passwordSand = entity.getPasswordSand();
		authToken = entity.getAuthToken();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		emailAddress = entity.getEmailAddress();
		gender = Gender.parse(entity.getGender());
		alias = entity.getAlias();
		avatar = entity.getAvatar();
		registerDateTime = entity.getRegisterDateTime();
		lastLoginDateTime = entity.getLastLoginDateTime();
		isActive = entity.isActive();
		userType = AmityUserType.from(entity.getUserType());
	}

	public String getAlias() {
		return alias;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public Long getId() {
		return id;
	}

	public DateTime getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPasswordSand() {
		return passwordSand;
	}

	public DateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public String getUserName() {
		return userName;
	}

	public AmityUserType getUserType() {
		return userType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPasswordSand(String passwordSand) {
		this.passwordSand = passwordSand;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserType(AmityUserType userType) {
		this.userType = userType;
	}

	public AmityUserDto toDto() {
		AmityUserDto amityUserDto = new AmityUserDto();
		amityUserDto.setAmityUserId(id);
		amityUserDto.setUserType(userType.getCode());
		amityUserDto.setUsername(userName);
		amityUserDto.setFirstName(firstName);
		amityUserDto.setLastName(lastName);
		amityUserDto.setEmailAddress(emailAddress);
		amityUserDto.setGender(gender.getCode());
		amityUserDto.setUserAlias(alias);
		return amityUserDto;
	}

	public AmityUserEntity toEntity() {
		AmityUserEntity entity = new AmityUserEntity();

		entity.setId(id);
		entity.setUserName(userName);
		entity.setEncryptedPassword(encryptedPassword);
		entity.setPasswordSand(passwordSand);
		entity.setAuthToken(authToken);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setEmailAddress(emailAddress);
		entity.setGender(gender.getCode());
		entity.setAlias(alias);
		entity.setAvatar(avatar);
		entity.setRegisterDateTime(registerDateTime);
		entity.setLastLoginDateTime(lastLoginDateTime);
		entity.setActive(isActive);
		entity.setUserType(userType.getCode());

		return entity;
	}
}
