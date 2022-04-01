package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.repo.PostRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.PostService;
import com.assignment.two.assignmenttwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{userId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody Post post, @PathVariable Long userId) {
        postService.addPost(post,userId);
    }
    @GetMapping("/{userId}/posts")
    public List<PostDTO> getUserPosts(@PathVariable("userId") long id){
        return postService.getPostByUser(id);
    }
    @GetMapping("/{userId}/posts/{title}")
    public ResponseEntity<List<PostDTO>> getPostLikeTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(postService.getPostByTitleLike(title),HttpStatus.OK);
    }
    @GetMapping("/posts/{title}")
    public ResponseEntity<List<UserDTO>> getUsersByPostTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(postService.getUserByPostTitle(title),HttpStatus.OK);
    }
}
