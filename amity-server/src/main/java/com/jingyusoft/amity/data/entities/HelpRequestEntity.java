package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "help_request")
@Audited(withModifiedFlag = true)
public class HelpRequestEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "version_lock")
	private Integer versionLock;

	public Long getId() {
		return id;
	}

	public Integer getVersionLock() {
		return versionLock;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVersionLock(Integer versionLock) {
		this.versionLock = versionLock;
	}
}
