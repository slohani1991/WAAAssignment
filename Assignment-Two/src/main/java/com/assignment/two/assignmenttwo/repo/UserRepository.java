package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.posts.size > 1 ")
    List<User> getUsersByMultiplePosts();

}
