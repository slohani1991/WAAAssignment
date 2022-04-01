package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.Comment;
import com.assignment.two.assignmenttwo.entity.DTO.CommentDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.helper.ListMapper;
import com.assignment.two.assignmenttwo.repo.CommentRepository;
import com.assignment.two.assignmenttwo.repo.PostRepository;
import com.assignment.two.assignmenttwo.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<Comment,CommentDTO> listMapper;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public List<CommentDTO> getPostComments(long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return (List<CommentDTO>) listMapper.mapList(commentRepository.getCommentByPost(post),new CommentDTO());
    }

    @Override
    public CommentDTO getCommentById(long id) {
        return modelMapper.map(commentRepository.getById(id),CommentDTO.class);
    }

    @Override
    public void addComment(Comment comment,long postID) {
        Post post = postRepository.findById(postID).orElseThrow();
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
