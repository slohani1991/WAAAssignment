package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.ExceptionData;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.repo.ExceptionDataRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    ExceptionDataRepository exceptionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addException(long user, String operation, Exception error) {
        User userData = userRepository.findById(user).orElseThrow();
        ExceptionData exceptionData = new ExceptionData(operation,userData,error.getMessage());
        exceptionRepository.save(exceptionData);
    }
}
