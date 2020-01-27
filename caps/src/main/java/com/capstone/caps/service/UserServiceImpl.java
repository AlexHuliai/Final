package com.capstone.caps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.caps.model.User;
import com.capstone.caps.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findEmail(email);
	}

	@Override
	public List<User> findByLastName(String lname) {
		// TODO Auto-generated method stub
		return repository.findByLastName(lname);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
		
	}

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(User user) {
	
			User user1 = findById(user.getId()).get();
			if(user1!=null) {
				user1.setFname(user.getFname());
				user1.setLname(user.getLname());
				user1.setTelephone(user.getTelephone());
			}
		
		
	}

}
