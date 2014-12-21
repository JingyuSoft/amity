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
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;

@Entity
@Table(name = "itinerary")
@Audited(withModifiedFlag = true)
public class ItineraryEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_itinerary_user"))
	private AmityUserEntity user;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "departure_city", foreignKey = @ForeignKey(name = "fk_itinerary_from_city"))
	@Audited(withModifiedFlag = true)
	private CityEntity departureCity;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "arrival_city", foreignKey = @ForeignKey(name = "fk_itinerary_to_city"))
	@Audited(withModifiedFlag = true)
	private CityEntity arrivalCity;

	@Column(name = "departure_date", columnDefinition = "DATE", nullable = false)
	@Type(type = Constants.JODA_TIME_PERSISTENT_CLASS)
	private DateTime departureDate;

	@Column(name = "arrival_date", columnDefinition = "DATE", nullable = false)
	@Type(type = Constants.JODA_TIME_PERSISTENT_CLASS)
	private DateTime arrivalDate;

	@Version
	@Column(name = "version_lock")
	private long versionLock;

	public CityEntity getArrivalCity() {
		return arrivalCity;
	}

	public DateTime getArrivalDate() {
		return arrivalDate;
	}

	public CityEntity getDepartureCity() {
		return departureCity;
	}

	public DateTime getDepartureDate() {
		return departureDate;
	}

	public Long getId() {
		return id;
	}

	public AmityUserEntity getUser() {
		return user;
	}

	public long getVersionLock() {
		return versionLock;
	}

	public void setArrivalCity(CityEntity arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setArrivalDate(DateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setDepartureCity(CityEntity departureCity) {
		this.departureCity = departureCity;
	}

	public void setDepartureDate(DateTime departureDate) {
		this.departureDate = departureDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(AmityUserEntity user) {
		this.user = user;
	}

	public void setVersionLock(long versionLock) {
		this.versionLock = versionLock;
	}
}
