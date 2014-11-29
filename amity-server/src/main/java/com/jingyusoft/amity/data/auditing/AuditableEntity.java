package com.jingyusoft.amity.data.auditing;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@MappedSuperclass
public abstract class AuditableEntity {

	@RevisionNumber
	@Column(name = "revision_number")
	private int revisionNumber;

	@RevisionTimestamp
	@Column(name = "revision_timestamp")
	private Date revisionTimestamp;

	public int getRevisionNumber() {
		return revisionNumber;
	}

	public Date getRevisionTimestamp() {
		return revisionTimestamp;
	}

	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public void setRevisionTimestamp(Date revisionTimestamp) {
		this.revisionTimestamp = revisionTimestamp;
	}
}
