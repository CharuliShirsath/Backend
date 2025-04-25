package com.pigdin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pigdin.dao.ApplicationRepository;
import com.pigdin.dao.JobRepository;
import com.pigdin.dao.UserRepository;
import com.pigdin.model.Application;
import com.pigdin.model.Job;
import com.pigdin.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private ApplicationRepository appRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
        User found = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (found != null) {
            session.setAttribute("userId", found.getId());
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/apply/{jobId}")
    public ResponseEntity<String> applyJob(@PathVariable Long jobId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).body("Please log in first.");

        User user = userRepo.findById(userId).orElse(null);
        Job job = jobRepo.findById(jobId).orElse(null);

        if (user == null || job == null) {
            return ResponseEntity.badRequest().body("User or Job not found.");
        }

        Application application = new Application(user, job);
        appRepo.save(application);
        return ResponseEntity.ok("Job applied");
    }

    @PostMapping("/upload-resume")
    public ResponseEntity<String> uploadResume(@RequestParam("path") String path, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).body("Please log in first.");

        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return ResponseEntity.badRequest().body("User not found.");

        user.setResumePath(path);
        userRepo.save(user);
        return ResponseEntity.ok("Resume uploaded");
    }

    @PostMapping("/create-profile")
    public ResponseEntity<String> createProfile(@RequestBody String summary, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).body("Please log in first.");

        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return ResponseEntity.badRequest().body("User not found.");

        user.setProfileSummary(summary);
        userRepo.save(user);
        return ResponseEntity.ok("Profile created");
    }
}
