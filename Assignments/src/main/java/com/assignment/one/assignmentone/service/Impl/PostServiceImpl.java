package com.assignment.one.assignmentone.service.Impl;

import com.assignment.one.assignmentone.entity.Post;
import com.assignment.one.assignmentone.repo.PostRepo;
import com.assignment.one.assignmentone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.getAllPosts();
    }

    @Override
    public Post getById(long id) {
        return postRepo.getByID(id);
    }

    @Override
    public Post addPost(Post post) {
        return postRepo.add(post);
    }

    @Override
    public String deletePost(long id) {
        return postRepo.delete(id);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepo.update(post);
    }
}
