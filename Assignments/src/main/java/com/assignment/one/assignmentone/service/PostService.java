package com.assignment.one.assignmentone.service;

import com.assignment.one.assignmentone.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    Post getById(long id);
    Post addPost(Post post);
    String deletePost(long id);
    Post updatePost(Post post);
}
