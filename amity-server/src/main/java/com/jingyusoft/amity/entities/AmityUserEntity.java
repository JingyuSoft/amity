package com.jingyusoft.amity.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.jingyusoft.amity.common.SecurityUtils;
import com.jingyusoft.amity.domain.AmityUserType;

@Entity
@Table(name = "amity_user")
public class AmityUserEntity {

	public static final String encryptPassword(final String password, final String sand) {
		return SecurityUtils.getBase64SHA256Hash(password + sand);
	}

	public static final String generateAuthToken(final String encryptedPassword) {
		return SecurityUtils.getBase64SHA256Hash(encryptedPassword + new Date().getTime());
	}

	public static final String DEFAULT_PASSWORD_SAND = "Amity";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", nullable = true, unique = true, length = 64)
	private String userName;

	@Column(name = "encrypted_password", nullable = true, length = 128)
	private String encryptedPassword;

	@Column(name = "password_sand", nullable = true, length = 64)
	private String passwordSand;

	/**
	 * Univer 2014-10-09 - The token is regenerated each time user login
	 */
	@Column(name = "auth_token", nullable = true)
	private String authToken;

	@Column(name = "first_name", length = 128, nullable = true)
	private String firstName;

	@Column(name = "last_name", length = 128, nullable = true)
	private String lastName;

	@Column(name = "email_address", nullable = true, unique = true, length = 128)
	private String emailAddress;

	@Column(name = "alias", unique = true, length = 64, nullable = true)
	private String alias;

	@Column(name = "avatar", nullable = true)
	@Lob
	private String avatar;

	@Column(name = "register_date", nullable = true)
	private Date registerDate;

	@Column(name = "last_login_date", nullable = true)
	private Date lastLoginDate;

	@Column(name = "is_active", nullable = true)
	private boolean isActive;

	@Column(name = "user_type", nullable = false, length = 1)
	private String userType;

	public AmityUserEntity() {
		setPasswordSand(DEFAULT_PASSWORD_SAND);
	}

	public String getAlias() {
		return alias;
	}

	public final AmityUserType getAmityUserType() {
		return AmityUserType.from(userType);
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

	public long getId() {
		return id;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPasswordSand() {
		return passwordSand;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserType() {
		return userType;
	}

	public boolean isActive() {
		return isActive;
	}

	@PrePersist
	public void prePersist() {
		registerDate = new Date();
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setAuthToken(String token) {
		authToken = token;
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

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPasswordSand(String passwordSand) {
		this.passwordSand = passwordSand;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
