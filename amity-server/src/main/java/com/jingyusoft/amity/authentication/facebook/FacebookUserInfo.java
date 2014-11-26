package com.jingyusoft.amity.authentication.facebook;

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

public class FacebookUserInfo {

	@SerializedName("id")
	private long id;

	@SerializedName("email")
	private String email;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("gender")
	private String gender;

	@SerializedName("link")
	private String link;

	@SerializedName("locale")
	private String locale;

	@SerializedName("name")
	private String name;

	@SerializedName("timezone")
	private int timezone;

	@SerializedName("updated_time")
	private DateTime updatedTime;

	@SerializedName("verified")
	private boolean verified;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGender() {
		return gender;
	}

	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLink() {
		return link;
	}

	public String getLocale() {
		return locale;
	}

	public String getName() {
		return name;
	}

	public int getTimezone() {
		return timezone;
	}

	public DateTime getUpdatedTime() {
		return updatedTime;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public void setUpdatedTime(DateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
}
