package com.jingyusoft.amity.data.auditing;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.jingyusoft.amity.data.entities.AmityUserEntity;

@Entity
@RevisionEntity(AmityRevisionListener.class)
public class AmityRevisionEntity extends DefaultRevisionEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "auditor_id", foreignKey = @ForeignKey(name = "amity_revision_entity_auditor_id"))
	private AmityUserEntity auditor;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AmityRevisionEntity other = (AmityRevisionEntity) obj;
		if (auditor == null) {
			if (other.auditor != null) {
				return false;
			}
		} else if (!auditor.equals(other.auditor)) {
			return false;
		}
		return true;
	}

	public AmityUserEntity getAuditor() {
		return auditor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (auditor == null ? 0 : auditor.hashCode());
		return result;
	}

	public void setAuditor(AmityUserEntity auditor) {
		this.auditor = auditor;
	}

	@Override
	public String toString() {
		return "AmityRevisionEntity [auditor=" + auditor + ", getId()=" + getId() + ", getTimestamp()="
				+ getTimestamp() + "]";
	}
}
