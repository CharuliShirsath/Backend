package com.Student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Dao.Student_Dao;
import com.Student.Model.Student;

@Service
public class Student_Service {
	
	@Autowired
	private Student_Dao studentDao;
	
	public List<Student> getAllStudents(){
		return studentDao.findAll();		
	}

	
	public Optional<Student> getStudentById(Long id) {
		
		return studentDao.findById(id);
	}


	
	public Student saveStudent(Student student) {
		
		return studentDao.save(student);
	}



	public void deleteStudent(Long id) {
		studentDao.deleteById(id);
		
	}

	
	
}
