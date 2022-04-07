package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.Comment;
import com.assignment.two.assignmenttwo.entity.DTO.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getPostComments(long postId);
    CommentDTO getCommentById(long id);
    void addComment(Comment comment,long postId);
    List<CommentDTO> getAllComments();

}
