package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.helper.ListMapper;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    private final ListMapper<User,UserDTO> listMapper;

    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, ListMapper<User, UserDTO> listMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return (List<UserDTO>) listMapper.mapList(userRepository.findAll(),new UserDTO());
    }

    @Override
    public UserDTO getUserById(long id) {
        return modelMapper.map(userRepository.findById(id).get(),UserDTO.class);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsersOfMultiplePost(int num) {
        return (List<UserDTO>) listMapper.mapList(userRepository.getUsersByMultiplePosts(num),new UserDTO());
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
