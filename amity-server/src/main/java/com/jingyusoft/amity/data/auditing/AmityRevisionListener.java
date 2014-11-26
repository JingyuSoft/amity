package com.jingyusoft.amity.data.auditing;

import org.hibernate.envers.RevisionListener;

public class AmityRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {

		AmityRevisionEntity entity = (AmityRevisionEntity) revisionEntity;
		// TODO: Update entity with current Amity user
		entity.setAuditor(null);
	}
}