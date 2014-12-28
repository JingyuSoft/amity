package com.jingyusoft.amity.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.data.entities.HelpRequestEntity;

@Repository
public interface HelpRequestRepository extends JpaRepository<HelpRequestEntity, Long> {

	@Query("SELECT i FROM HelpRequestEntity i WHERE i.user.id = :amityUserId")
	List<HelpRequestEntity> listHelpRequests(final long amityUserId);
}
