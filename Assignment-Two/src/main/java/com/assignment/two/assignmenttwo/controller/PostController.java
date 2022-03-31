package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.repo.PostRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.PostService;
import com.assignment.two.assignmenttwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody Post post, @PathVariable Long userId) {
        postService.addPost(post,userId);
    }
    @GetMapping
    public List<PostDTO> getUserPosts(@PathVariable("userId") long id){
        return postService.getPostByUser(id);
    }
}
