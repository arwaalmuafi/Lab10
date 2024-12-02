package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lab10/JobApplication")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/applications")
    public ResponseEntity<List<JobApplication>> getAllApplications() {
        return ResponseEntity.status (200).body(jobApplicationService.getAllApplications());
    }

    @PostMapping("/apply/{userId}/{jobId}")
    public ResponseEntity applyForJob(@PathVariable Integer userId, @PathVariable Integer jobId,JobApplication jobApplication) {

        boolean isApplied = jobApplicationService.applyForJob(userId,jobId,jobApplication);

        if (isApplied) {
            return ResponseEntity.status(200).body(new ApiResponse( "Job application added"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Failed to create job application"));
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity withdrawApplication(@PathVariable Integer id) {
        boolean isDeleted = jobApplicationService.withdrawApplication(id);

        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application withdrawn "));
        }
        return ResponseEntity.status(404).body(new ApiResponse( "Job application not found"));
    }





}
