package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.DTO.PostDTO;
import com.assignment.two.assignmenttwo.entity.DTO.UserDTO;
import com.assignment.two.assignmenttwo.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(long id);

    void addUser(User user);

    List<UserDTO> getAllUsersOfMultiplePost();

}
