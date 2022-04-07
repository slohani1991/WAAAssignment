package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.entity.Comment;
import com.assignment.two.assignmenttwo.entity.DTO.CommentDTO;
import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.service.CommentService;
import com.assignment.two.assignmenttwo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/filter")
    public ResponseEntity<List<UserDTO>> getUsersByPostTitle(@RequestParam("title") String title){
        return new ResponseEntity<>(postService.getUserByPostTitle(title),HttpStatus.OK);
    }
    @GetMapping("/{title}")
    public ResponseEntity<List<PostDTO>> getPostLikeTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(postService.getPostByTitleLike(title),HttpStatus.OK);
    }
    @GetMapping("/{postId}/comments/")
    public ResponseEntity<List<CommentDTO>> getPostComments(@PathVariable("postId") long postId){
        return new ResponseEntity<>(commentService.getPostComments(postId),HttpStatus.OK);
    }

    @PostMapping("/{postId}/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@PathVariable("postId") long postId, @RequestBody Comment comment){
        commentService.addComment(comment,postId);
    }

}
