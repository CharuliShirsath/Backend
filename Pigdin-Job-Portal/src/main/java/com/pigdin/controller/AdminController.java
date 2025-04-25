package com.pigdin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pigdin.dao.AdminRepository;
import com.pigdin.dao.JobRepository;
import com.pigdin.model.Admin;
import com.pigdin.model.Job;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private JobRepository jobRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Admin admin) {
        adminRepo.save(admin);
        return ResponseEntity.ok("Admin registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin, HttpSession session) {
        Admin found = adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
        if (found != null) {
            session.setAttribute("adminId", found.getId());
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/add-job")
    public ResponseEntity<String> addJob(@RequestBody Job job, HttpSession session) {
        if (session.getAttribute("adminId") == null) return ResponseEntity.status(401).build();
        jobRepo.save(job);
        return ResponseEntity.ok("Job added");
    }

    @PutMapping("/edit-job/{id}")
    public ResponseEntity<String> editJob(@PathVariable Long id, @RequestBody Job jobDetails, HttpSession session) {
        if (session.getAttribute("adminId") == null) return ResponseEntity.status(401).build();
        Job job = jobRepo.findById(id).orElseThrow();
        job.setTitle(jobDetails.getTitle());
        job.setDescription(jobDetails.getDescription());
        job.setLocation(jobDetails.getLocation());
        jobRepo.save(job);
        return ResponseEntity.ok("Job updated");
    }

    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("adminId") == null) return ResponseEntity.status(401).build();
        jobRepo.deleteById(id);
        return ResponseEntity.ok("Job deleted");
    }
}
