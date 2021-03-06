package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;

import com.jingyusoft.amity.data.DataConstants;

@Entity
@Table(name = "amity_user")
public class AmityUserEntity {

	public static final String DEFAULT_PASSWORD_SAND = "Amity";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = true, unique = true, length = 64)
	@Audited(withModifiedFlag = true)
	private String userName;

	@Column(name = "encrypted_password", nullable = true, length = 128)
	@Audited(withModifiedFlag = true)
	private String encryptedPassword;

	@Column(name = "password_sand", nullable = true, length = 64)
	@Audited(withModifiedFlag = true)
	private String passwordSand;

	/**
	 * Univer 2014-10-09 - The token is regenerated each time user login
	 */
	@Column(name = "auth_token", nullable = true)
	@Audited(withModifiedFlag = true)
	private String authToken;

	@Column(name = "first_name", length = 128, nullable = true)
	@Audited(withModifiedFlag = true)
	private String firstName;

	@Column(name = "last_name", length = 128, nullable = true)
	@Audited(withModifiedFlag = true)
	private String lastName;

	@Column(name = "email_address", nullable = false, unique = true, length = 128)
	@Audited(withModifiedFlag = true)
	private String emailAddress;

	@Column(name = "gender", nullable = true, unique = false, length = 1)
	@Audited(withModifiedFlag = true)
	private String gender;

	@Column(name = "alias", unique = true, length = 64, nullable = true)
	@Audited(withModifiedFlag = true)
	private String alias;

	@Column(name = "avatar", nullable = true, length = 128)
	@Audited(withModifiedFlag = true)
	private String avatar;

	@Column(name = "register_date_time", nullable = false)
	@Type(type = DataConstants.JODA_TIME_PERSISTENT_CLASS)
	private DateTime registerDateTime;

	@Column(name = "last_login_date_time", nullable = true)
	@Type(type = DataConstants.JODA_TIME_PERSISTENT_CLASS)
	@Audited(withModifiedFlag = true)
	private DateTime lastLoginDateTime;

	@Column(name = "is_active", nullable = true)
	@Audited(withModifiedFlag = true)
	private boolean isActive;

	@Column(name = "user_type", nullable = false, length = 1)
	private String userType;

	@Version
	@Column(name = "version_lock")
	private long versionLock;

	public AmityUserEntity() {
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

	public String getGender() {
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

	public String getUserType() {
		return userType;
	}

	public long getVersionLock() {
		return versionLock;
	}

	public boolean isActive() {
		return isActive;
	}

	@PrePersist
	private void prePersist() {
		isActive = true;
		registerDateTime = DateTime.now();
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastLoginDateTime(DateTime lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPasswordSand(String passwordSand) {
		this.passwordSand = passwordSand;
	}

	public void setRegisterDateTime(DateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setVersionLock(long versionLock) {
		this.versionLock = versionLock;
	}
}
