package com.jingyusoft.amity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "itinerary")
public class ItineraryEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@ForeignKey(name = "fk_itinerary_user")
	@JoinColumn(name = "user_id")
	private AmityUserEntity user;

	public long getId() {
		return id;
	}

	public AmityUserEntity getUser() {
		return user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser(AmityUserEntity user) {
		this.user = user;
	}
}
