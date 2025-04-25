package com.Student.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.Model.Student;

@Repository
public interface Student_Dao extends JpaRepository<Student, Long>{

}
