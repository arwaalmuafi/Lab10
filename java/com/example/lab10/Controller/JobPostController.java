package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lab10/JobPost")
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity  getAllJobs(){
        return ResponseEntity.status(200).body(jobPostService.getAllJobs());
    }

    @PostMapping("/add")
    public ResponseEntity addJobs(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        jobPostService.addJobs(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("job post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id,@RequestBody @Valid JobPost jobPost,Errors errors ){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        Boolean isUpdated=jobPostService.updateJobs(id,jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("job post updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("job post not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id){

        Boolean isDeleted=jobPostService.deleteJobPost(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("job post is deleted"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("job post not found"));
    }





}
