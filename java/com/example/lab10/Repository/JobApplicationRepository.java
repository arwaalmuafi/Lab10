package com.example.lab10.Repository;

import com.example.lab10.Model.JobApplication;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer> {
    boolean existsByUserIdAndJobId(@NotNull(message = "Cannot be null") Integer userId, @NotNull(message = "Cannot be null") Integer jobId);
}
