package com.spice.smsotpms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spice.smsotpms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	@Query("select u from User u where u.active = 1 and u.username = ?1")
	Optional<User> findByMobile(@Param("username") String mobileNo);
	
	User findByUsername(String mobileNo);
}
