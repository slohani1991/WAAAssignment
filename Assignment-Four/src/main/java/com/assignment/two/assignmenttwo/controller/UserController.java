package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.aspect.annotation.ExecutionTime;
import com.assignment.two.assignmenttwo.entity.DTO.CommentDTO;
import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.service.CommentService;
import com.assignment.two.assignmenttwo.service.PostService;
import com.assignment.two.assignmenttwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @PostMapping
    public void addUsers(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @ExecutionTime

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

    @GetMapping("/posts/list/{num}")
    public List<UserDTO> getUserByMultiplePost(@PathVariable("num") int num){
        return userService.getAllUsersOfMultiplePost(num);
    }

    //Post Domains

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @GetMapping(value = "/posts")
    public List<PostDTO> getUserPosts(){
        return postService.getPostByUser();
    }

    @GetMapping("{userId}/posts/{postId}")
    public PostDTO getPostById(@PathVariable("postId") long postId){
        return postService.getPostById(postId);
    }

    //comment domain

    @GetMapping("{userId}/posts/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> getPostComments(@PathVariable("postId") long postId){
        return new ResponseEntity<>(commentService.getPostComments(postId),HttpStatus.OK);
    }

    @GetMapping("{userId}/posts/{postId}/comments/{commentId}")
    public CommentDTO getPostByCommentId(@PathVariable("commentId") long commentId){
        return commentService.getCommentById(commentId);
    }



}
