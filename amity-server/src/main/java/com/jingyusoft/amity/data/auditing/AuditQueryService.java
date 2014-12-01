package com.jingyusoft.amity.data.auditing;

import java.util.List;

public interface AuditQueryService {

	<T> List<AmityEntityRevision<T>> queryAudit(Class<T> entityClass);
}
