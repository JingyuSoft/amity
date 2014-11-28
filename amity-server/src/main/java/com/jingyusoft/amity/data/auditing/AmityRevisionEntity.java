package com.jingyusoft.amity.data.auditing;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.jingyusoft.amity.data.entities.AmityUserEntity;

@Entity(name = "amity_audit_revision")
@RevisionEntity(AmityRevisionListener.class)
public class AmityRevisionEntity extends DefaultRevisionEntity {

	private static final long serialVersionUID = -5226516057482625922L;

	@ManyToOne
	@JoinColumn(name = "amity_user_id", foreignKey = @ForeignKey(name = "amity_revision_entity_amity_user_id"))
	private AmityUserEntity amityUser;

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
		if (amityUser == null) {
			if (other.amityUser != null) {
				return false;
			}
		} else if (!amityUser.equals(other.amityUser)) {
			return false;
		}
		return true;
	}

	public AmityUserEntity getAmityUser() {
		return amityUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (amityUser == null ? 0 : amityUser.hashCode());
		return result;
	}

	public void setAmityUser(AmityUserEntity amityUser) {
		this.amityUser = amityUser;
	}

	@Override
	public String toString() {
		return "AmityRevisionEntity [amityUser=" + amityUser + "]";
	}
}
