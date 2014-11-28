package com.jingyusoft.amity.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.data.entities.AmityUserEntity;

@Repository
public interface AmityUserRepository extends JpaRepository<AmityUserEntity, Long> {
}
