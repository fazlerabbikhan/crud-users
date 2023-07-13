package com.fazlerabbikhan.crudusers.controller;

import com.fazlerabbikhan.crudusers.entity.UserEntity;
import com.fazlerabbikhan.crudusers.model.response.UserResponse;
import com.fazlerabbikhan.crudusers.repository.UserRepository;
import com.fazlerabbikhan.crudusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //Get all employees
    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    //Create an employee
    @PostMapping("save")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    //Get an employee by ID
    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable long id){
       return userService.getUserById(id);
    }

    // Update an employee
    @PutMapping("{id}")
    public UserResponse updateUser(@PathVariable long id, @RequestBody UserEntity userEntity) {
        return userService.updateUser(id, userEntity);
    }

    // Delete an employee
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

}