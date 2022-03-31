package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;

import java.util.List;

public interface PostService {

    void addPost(Post post,long userId);

    List<PostDTO> getAllPost();

    PostDTO getPostById(long id);

    void deletePost(long id);

    void updatePost(Post post);

    List<PostDTO> getPostByUser(long id);

}
