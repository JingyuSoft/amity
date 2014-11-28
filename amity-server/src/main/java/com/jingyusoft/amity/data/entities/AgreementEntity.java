package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "agreement")
public class AgreementEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "help_request_id", foreignKey = @ForeignKey(name = "fk_agreement_help_request_id"))
	private HelpRequestEntity helpRequest;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "helper_id", foreignKey = @ForeignKey(name = "fk_agreement_helper_id"))
	private AmityUserEntity helper;

	@Column(name = "create_date_time", nullable = false)
	@Type(type = Constants.JODA_TIME_PERSISTENT_CLASS)
	private DateTime createDateTime;

	@Version
	@Column(name = "version_lock")
	private Integer versionLock;

	public DateTime getCreateDateTime() {
		return createDateTime;
	}

	public AmityUserEntity getHelper() {
		return helper;
	}

	public HelpRequestEntity getHelpRequest() {
		return helpRequest;
	}

	public long getId() {
		return id;
	}

	public Integer getVersionLock() {
		return versionLock;
	}

	@PrePersist
	private void prePersist() {
		createDateTime = DateTime.now();
	}

	public void setCreateDateTime(DateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setHelper(AmityUserEntity helper) {
		this.helper = helper;
	}

	public void setHelpRequest(HelpRequestEntity helpRequest) {
		this.helpRequest = helpRequest;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVersionLock(Integer versionLock) {
		this.versionLock = versionLock;
	}
}