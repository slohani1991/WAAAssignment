package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.Post;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.helper.ListMapper;
import com.assignment.two.assignmenttwo.repo.PostRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;

    private final PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ListMapper<Post,PostDTO> listMapper;
    @Autowired
    ListMapper<User,UserDTO> userListMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(Post post,long id) {
        post.setUser(userRepository.findById(id).orElseThrow());
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
        return (List<PostDTO>)listMapper.mapList(postRepository.findAll(),new PostDTO());
    }

    @Override
    public PostDTO getPostById(long id) {
        return modelMapper.map(postRepository.getById(id),PostDTO.class);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getPostByUser(long id) {
        User userdata = userRepository.findById(id).orElseThrow();
        return (List<PostDTO>)listMapper.mapList(postRepository.findAllByUser(userdata),new PostDTO());
    }

    @Override
    public List<PostDTO> getPostByTitleLike(String title) {
        return (List<PostDTO>) listMapper.mapList(postRepository.findPostByTitleIs(title),new PostDTO());
    }

    @Override
    public List<UserDTO> getUserByPostTitle(String title) {
        return (List<UserDTO>)userListMapper.mapList(postRepository.findPostByTitleIsOrderByUser(title),new UserDTO());
    }


}
