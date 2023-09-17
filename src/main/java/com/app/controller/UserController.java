package com.app.controller;

import com.app.Service.UserServiceImpl;

import com.app.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")

    public ResponseEntity<User>save(@RequestBody User user){
        User user1=userService.savePost(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public List<User> getAlluser(){
       List<User> user= userService.getall() ;
        return user;

    }
    @PutMapping
    public ResponseEntity<User>update(@RequestBody User user,@PathVariable Long id){
        User updateuser = userService.updateuser(user, id);
        return new ResponseEntity<>(updateuser,HttpStatus.CREATED);
    }


        }




