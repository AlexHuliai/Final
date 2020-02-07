package com.capston.caps.service;

import java.util.List;
import java.util.Optional;

import com.capston.caps.model.Users;

public interface UserService {

	Optional<Users> findById(int user_id);
	void delete(int user_id);
	void save(Users users);
	void update(Users users);
	List<Users> findAll();
	Optional<Users> findByEmail(String email);
	List<Users> findByLastname(String lname);
}
