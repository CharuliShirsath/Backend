package com.pigdin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pigdin.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {}