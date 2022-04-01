package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.entity.Comment;
import com.assignment.two.assignmenttwo.entity.DTO.CommentDTO;
import com.assignment.two.assignmenttwo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/posts/{postId}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@PathVariable("postId") long postId, @RequestBody Comment comment){
        commentService.addComment(comment,postId);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getPostComments(@PathVariable("postId") long postId){
        return new ResponseEntity<List<CommentDTO>>(commentService.getPostComments(postId),HttpStatus.OK);
    }
    @GetMapping("/{commentId}")
    public CommentDTO getPostById(@PathVariable("commentId") long commentId){
        return commentService.getCommentById(commentId);
    }





}
