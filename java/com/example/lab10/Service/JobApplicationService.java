package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    public Boolean applyForJob(Integer userId, Integer jobId, JobApplication jobApplication) {
        Boolean jobExists = jobPostRepository.existsById(jobId);
        if (!jobExists) {
            return false;
        }

        Boolean userExists = userRepository.existsById(userId);
        if (!userExists) {
            return false;
        }

        jobApplication.setJobId(jobId);
        jobApplication.setUserId(userId);

        jobApplicationRepository.save(jobApplication);

        return true;
    }


        public Boolean withdrawApplication (Integer id){
            if (!jobApplicationRepository.existsById(id)) {
                return false;
            }

            jobApplicationRepository.deleteById(id);
            return true;
        }


    }
