package com.pigdin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pigdin.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {}