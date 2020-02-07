package com.capston.caps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capston.caps.model.Users;
import com.capston.caps.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Optional<Users> findByEmail(String email) {
		return repository.findEmail(email);
	}

	@Override
	public List<Users> findByLastname(String lname) {		
		return repository.findBylastName(lname);
	}

	@Override
	public Optional<Users> findById(int user_id) {
		return repository.findById(user_id);
	}

	@Override
	public void delete(int user_id) {
		repository.deleteById(user_id);
	}

	@Override
	public void save(Users users) {
		repository.save(users);
	}

	@Override
	public void update(Users users) {
		Users user=findById(users.getUser_id()).get();
		if(user !=null) {
			user.setFname(users.getFname());
			user.setLname(users.getLname());
			user.setPhone(users.getPhone());
		}
	}
	

	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

}
