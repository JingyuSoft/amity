package com.jingyusoft.amity.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.data.entities.ItineraryEntity;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {
}
