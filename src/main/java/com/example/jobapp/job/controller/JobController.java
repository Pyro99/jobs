package com.example.jobapp.job.controller;

import com.example.jobapp.job.entity.Job;
import com.example.jobapp.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
    List<Job> jobs = jobService.findAll();
    return new ResponseEntity<>(jobs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable Long id){
        jobService.updateJob(id,job);
        return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        jobService.deleteJobById(id);
        return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
    }
}
