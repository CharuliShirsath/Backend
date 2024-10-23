package com.omfys.service;

import java.util.List;
import java.util.Optional;

import com.omfys.model.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUser() ;
	public Optional<User> getUSerDetails(Long id);
	public User updateUserDetails(Long id, User user);
	public void deleteUser(Long id);

}
