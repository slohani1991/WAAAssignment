package com.assignment.one.assignmentone.repo;

import com.assignment.one.assignmentone.entity.Post;

import java.util.List;

public interface PostRepo {

   List<Post> getAllPosts();
   Post getByID(long id);
   Post add(Post post);
   Post update(Post post);
   String delete(long id);

}
