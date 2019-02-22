package com.sfeir.graph.assetmanager.reference.repository;

import com.sfeir.graph.assetmanager.reference.user.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface UserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String username);

	List<AppUser> findByName(String name);

	@Query("UPDATE AppUser u SET u.lastLogin=:lastLogin WHERE u.username = :username")
	@Modifying
	@Transactional
	void updateLastLogin(@Param("lastLogin") Date lastLogin, @Param("username") String username);

}
