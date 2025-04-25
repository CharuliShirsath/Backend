package com.pigdin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pigdin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmailAndPassword(String email, String password);
}