package com.jingyusoft.amity.data.dao;

import java.util.Optional;

import com.jingyusoft.amity.data.entities.AmityUserEntity;

public interface UserAccountDao {

	Optional<AmityUserEntity> getAmityUserByEmail(final String emailAddress);
}
