package com.example.service;

import com.example.model.AdminRegister;
import com.example.model.UserRegister;
import com.example.repository.AdminRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> adminLogin(String username, String password) {
        AdminRegister admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return new ResponseEntity<>("Admin login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
