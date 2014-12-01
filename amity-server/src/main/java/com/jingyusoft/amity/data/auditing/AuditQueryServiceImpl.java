package com.jingyusoft.amity.data.auditing;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditQueryServiceImpl implements AuditQueryService {

	@Resource
	private EntityManager entityManager;

	@Override
	@Transactional
	public <T> List<AmityEntityRevision<T>> queryAudit(Class<T> entityClass) {

		AuditReader auditReader = AuditReaderFactory.get(entityManager);

		@SuppressWarnings("unchecked")
		List<Object[]> revisions = auditReader.createQuery().forRevisionsOfEntity(entityClass, false, true)
				.getResultList();

		List<AmityEntityRevision<T>> result = revisions.stream().map(item -> new AmityEntityRevision<T>(item))
				.collect(Collectors.toList());

		return result;
	}
}
