package com.omfys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omfys.model.User;
import com.omfys.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping("/insert")
	public User addUserDetails(@RequestBody User user){

		return userservice.createUser(user);
	}

	@GetMapping("/allusers")
	public List<User> getAllUSer(){

		return userservice.getAllUser();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable Long id) {

		User user=userservice.getUSerDetails(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);

		}
		else
			return ResponseEntity.notFound().build();
	}


	@PutMapping("/updateduser/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable Long id,@RequestBody  User newuser) {

		User updatedUser = userservice.updateUserDetails(id, newuser);
		if(updatedUser != null) {
			return ResponseEntity.ok(updatedUser);		
		}
		else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userservice.deleteUser(id);
	
		return ResponseEntity.noContent().build();
		
	}
}
