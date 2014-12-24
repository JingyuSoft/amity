package com.jingyusoft.amity.data.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.data.entities.AmityUserEntity;

@Service
public class UserAccountDaoImpl implements UserAccountDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<AmityUserEntity> getAmityUserByEmail(String emailAddress) {
		List<AmityUserEntity> list = entityManager
				.createQuery("SELECT e FROM AmityUserEntity e WHERE e.emailAddress = :emailAddress",
						AmityUserEntity.class).setParameter("emailAddress", emailAddress).getResultList();

		return list.size() == 1 ? Optional.of(list.get(0)) : Optional.empty();
	}
}
