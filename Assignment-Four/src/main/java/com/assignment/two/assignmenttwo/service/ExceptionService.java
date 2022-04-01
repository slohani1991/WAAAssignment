package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.entity.ExceptionData;

public interface ExceptionService {

    void addException(long user,String operation,Exception error);

}
