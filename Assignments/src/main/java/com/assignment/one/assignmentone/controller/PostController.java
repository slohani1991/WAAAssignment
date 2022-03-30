package com.assignment.one.assignmentone.controller;

import com.assignment.one.assignmentone.entity.Post;
import com.assignment.one.assignmentone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") long id){
        return postService.getById(id);
    }
    @PostMapping
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
       postService.deletePost(id);
    }
    @PutMapping
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }



}
