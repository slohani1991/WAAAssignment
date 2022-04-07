package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;

import java.util.List;

public interface PostService {


    List<PostDTO> getPostByUser();

    List<PostDTO> getPostByTitleLike(String title);

    List<UserDTO> getUserByPostTitle(String title);

    void addPost(Post post);

    List<PostDTO> getAllPost();

    PostDTO getPostById(long id);



}
