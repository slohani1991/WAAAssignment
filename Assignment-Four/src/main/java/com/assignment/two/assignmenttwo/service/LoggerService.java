package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.Logger;
import com.assignment.two.assignmenttwo.entity.User;

import java.util.List;

public interface LoggerService {

    void addLogData(long user, String operation);
    List<Logger> getLogData();

}
