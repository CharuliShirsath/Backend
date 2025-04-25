package com.pigdin.model;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Application {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private User user;

	    @ManyToOne
	    private Job job;

	    public Application() {}

	    public Application(User user, Job job) {
	        this.user = user;
	        this.job = job;
	    }

	

}
