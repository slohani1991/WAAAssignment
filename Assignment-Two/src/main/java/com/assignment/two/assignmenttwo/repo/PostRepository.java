package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);
}
