package com.jingyusoft.amity.data.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.data.entities.ItineraryEntity;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

	@Query("SELECT i FROM ItineraryEntity i WHERE i.user.id = :amityUserId")
	List<ItineraryEntity> listItineraries(@Param("amityUserId") final long amityUserId);

	@Query("SELECT i FROM ItineraryEntity i WHERE i.departureCity.id in :departureCityIds and i.arrivalCity.id in :arrivalCityIds")
	List<ItineraryEntity> searchItineraries(@Param("departureCityIds") final Set<Integer> departureCityIds,
			@Param("arrivalCityIds") final Set<Integer> arrivalCityIds);
}
