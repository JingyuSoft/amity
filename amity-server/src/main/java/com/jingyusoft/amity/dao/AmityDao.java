package com.jingyusoft.amity.dao;

import java.io.Serializable;
import java.util.List;

public interface AmityDao<TEntity, TIdentity extends Serializable> {

	TEntity get(TIdentity id);

	List<TEntity> getAll();

	Class<TEntity> getEntityClass();

	Class<TIdentity> getIdentityClass();

	TEntity merge(TEntity entity);

	void persist(TEntity entity);

	void remove(TEntity entity);

	void remove(TIdentity id);
}
