package com.Student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Model.Student;
import com.Student.Service.Student_Service;

@RestController
@RequestMapping("/Students")
public class Student_Controller {
	
	@Autowired
	private Student_Service studentService;
	
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> ResponseEntity.ok().body(value))
                      .orElseGet(() -> ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student ){
		Student createdStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
		
	}
}
