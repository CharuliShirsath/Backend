package com.omfys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.model.User;
import com.omfys.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	
	@Override
	public User createUser(User user) {
		
		return userdao.save(user);
	}


	@Override
	public List<User> getAllUser() {
		
		return userdao.findAll();
	}


	@Override
	public Optional<User> getUSerDetails(Long id) {
		
		return userdao.findById(id);
	}


	@Override
	public User updateUserDetails(Long id, User newuser) {
		
		User userData = userdao.findById(id).orElse(null);
		if(userData != null) {
			return userdao.save(newuser);
		}
		else {
			throw new RuntimeException("User not fount with id: "+ id);
		}
		
	}


	@Override
	public void deleteUser(Long id) {
		 userdao.deleteById(id);
		
	}
}
