package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "help_request")
public class HelpRequestEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Version
	@Column(name = "version_lock")
	private Integer versionLock;

	public long getId() {
		return id;
	}

	public Integer getVersionLock() {
		return versionLock;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVersionLock(Integer versionLock) {
		this.versionLock = versionLock;
	}
}
