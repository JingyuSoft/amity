package com.jingyusoft.amity.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.data.entities.ItineraryEntity;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

	@Query("SELECT i FROM ItineraryEntity i WHERE i.user.id = :amityUserId")
	List<ItineraryEntity> listItineraries(final long amityUserId);
}
