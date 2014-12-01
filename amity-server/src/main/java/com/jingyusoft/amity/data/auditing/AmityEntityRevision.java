package com.jingyusoft.amity.data.auditing;

import org.hibernate.envers.RevisionType;

public class AmityEntityRevision<TEntity> {

	private final TEntity entity;

	private final AmityRevisionEntity amityRevisionEntity;

	private final RevisionType revisionType;

	@SuppressWarnings("unchecked")
	public AmityEntityRevision(Object[] objects) {
		this.entity = (TEntity) objects[0];
		this.amityRevisionEntity = (AmityRevisionEntity) objects[1];
		this.revisionType = (RevisionType) objects[2];
	}

	public AmityRevisionEntity getAmityRevisionEntity() {
		return amityRevisionEntity;
	}

	public TEntity getEntity() {
		return entity;
	}

	public RevisionType getRevisionType() {
		return revisionType;
	}
}
