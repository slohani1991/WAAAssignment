package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Comment;
import com.assignment.two.assignmenttwo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> getCommentByPost(Post post);

}
