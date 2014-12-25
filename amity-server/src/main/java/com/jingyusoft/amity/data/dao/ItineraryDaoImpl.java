package com.jingyusoft.amity.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.data.entities.ItineraryEntity;

@Service
public class ItineraryDaoImpl implements ItineraryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ItineraryEntity> listItineraries(long amityUserId) {

		@SuppressWarnings("unchecked")
		List<ItineraryEntity> itineries = entityManager
				.createQuery("SELECT i FROM ItineraryEntity i WHERE i.user.id = :amityUserId")
				.setParameter("amityUserId", amityUserId).getResultList();
		return itineries;
	}
}
