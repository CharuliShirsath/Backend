package com.omfys.repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.omfys.model.Student; 


public interface StudentRepository 
	extends JpaRepository<Student, Long> { 
}
