package com.capstone.caps.service;

import java.util.List;
import java.util.Optional;

import com.capstone.caps.model.User;

public interface UserService {
	Optional<User> findByEmail(String email);
	List<User> findByLastName(String lname);
	void delete(long id);
	void save(User user);
	Optional<User> findById(long id);
	List<User> findAll();
	void update(User user);
}
