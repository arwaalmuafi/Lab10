package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUSer(User user){
        userRepository.save(user);
    }

    public Boolean updateUSer(Integer id, User user){
        User oldUSer=userRepository.getById(id);

        if(oldUSer==null){
            return false;
        }

        oldUSer.setName(user.getName());
        oldUSer.setEmail(user.getEmail());
        oldUSer.setAge(user.getAge());
        oldUSer.setRole(user.getRole());
        oldUSer.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user=userRepository.getById(id);

        if(user==null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }

}
