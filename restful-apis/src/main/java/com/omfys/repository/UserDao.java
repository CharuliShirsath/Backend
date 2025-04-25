package com.omfys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omfys.model.User;

public interface UserDao extends JpaRepository<User, Long>{

}
