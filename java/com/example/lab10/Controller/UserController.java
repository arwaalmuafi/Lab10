package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lab10/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUSer(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        userService.addUSer(user);

        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUSer(@PathVariable Integer id,@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        Boolean isUpdated=userService.updateUSer(id,user);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("user is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("user not found"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUSer(@PathVariable Integer id){
        Boolean isDeleted=userService.deleteUser(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user is deleted"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("user not found"));
    }


}
