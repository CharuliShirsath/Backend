package com.example.controller;

import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestParam String username, @RequestParam String password) {
        return adminService.adminLogin(username, password);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return adminService.deleteUserById(id);
    }
}
