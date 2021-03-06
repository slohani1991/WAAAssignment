package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.service.PostService;
import com.assignment.two.assignmenttwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public void addUsers(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/posts/list")
    public List<UserDTO> getUserByMultiplePost(){
        return userService.getAllUsersOfMultiplePost();
    }

}
