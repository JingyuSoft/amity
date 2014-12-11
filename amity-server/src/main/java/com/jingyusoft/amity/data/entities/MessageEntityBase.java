package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

@MappedSuperclass
public abstract class MessageEntityBase {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "send_date_time", nullable = false)
	private DateTime sendDateTime;

	@Column(name = "read_date_time", nullable = false)
	private DateTime readDateTime;

	public long getId() {
		return id;
	}

	public DateTime getReadDateTime() {
		return readDateTime;
	}

	public DateTime getSendDateTime() {
		return sendDateTime;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setReadDateTime(DateTime readDateTime) {
		this.readDateTime = readDateTime;
	}

	public void setSendDateTime(DateTime sendDateTime) {
		this.sendDateTime = sendDateTime;
	}
}
