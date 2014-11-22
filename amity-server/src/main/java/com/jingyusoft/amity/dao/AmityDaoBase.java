package com.jingyusoft.amity.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

public abstract class AmityDaoBase<TEntity, TIdentity extends Serializable> implements AmityDao<TEntity, TIdentity> {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(AmityDaoBase.class);

	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<TEntity> entityClass;

	private final Class<TIdentity> identityClass;

	@SuppressWarnings("unchecked")
	protected AmityDaoBase() {
		entityClass = (Class<TEntity>) GenericTypeResolver.resolveTypeArguments(getClass(), AmityDaoBase.class)[0];
		identityClass = (Class<TIdentity>) GenericTypeResolver.resolveTypeArguments(getClass(), AmityDaoBase.class)[1];
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public TEntity get(final TIdentity id) {
		TEntity entity = entityManager.find(getEntityClass(), id);
		if (entity == null) {
			return null;
		}
		return entity;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<TEntity> getAll() {
		final String sql = "FROM " + entityClass.getSimpleName();
		List<TEntity> list = entityManager.createQuery(sql, entityClass).getResultList();
		List<TEntity> resultList = Lists.newArrayList();
		for (TEntity entity : list) {
			if (!entityManager.contains(entity)) {
				resultList.add(entityManager.merge(entity));
			} else {
				resultList.add(entity);
			}
		}

		return resultList;
	}

	@Override
	public final Class<TEntity> getEntityClass() {
		return entityClass;
	}

	@Override
	public final Class<TIdentity> getIdentityClass() {
		return identityClass;
	}

	@Override
	@Transactional
	public TEntity merge(final TEntity entity) {
		TEntity savedOrUpdatedEntity = entityManager.merge(entity);
		entityManager.flush();
		return savedOrUpdatedEntity;
	}

	@Override
	@Transactional
	public void persist(TEntity entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	@Override
	@Transactional
	public void remove(TEntity entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		entityManager.flush();
	}

	@Override
	@Transactional
	public void remove(TIdentity id) {
		TEntity entity = get(id);
		if (entity != null) {
			entityManager.remove(entity);
		}
	}
}
