package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.Logger;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.repo.LoggerRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    LoggerRepository loggerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addLogData(long user, String operation) {
        User userData = userRepository.findById(user).orElseThrow();
        Logger logData=new Logger(operation,userData);
        loggerRepository.save(logData);
    }

    @Override
    public List<Logger> getLogData() {
        return null;
    }
}
