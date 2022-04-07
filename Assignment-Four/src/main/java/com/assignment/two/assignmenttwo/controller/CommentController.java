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
@RequestMapping("api/v1/comments/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(),HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public CommentDTO getPostById(@PathVariable("commentId") long commentId){
        return commentService.getCommentById(commentId);
    }





}
