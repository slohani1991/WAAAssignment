package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);
    List<Post> findPostByTitleIs(String title);
    @Query("select u.user from Post u where u.title= :title")
    List<User> findPostByTitleIsOrderByUser(String title);
}
