package com.capstone.caps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	@Query("From User where email =?1")
	Optional<User> findEmail(String email);
	
	@Query("FROM User WHERE last_name=?1 OR first_name=?1 OR email=?1")
	List<User> findByLastName(String lastname);
	
	
}
