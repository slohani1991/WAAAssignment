package com.assignment.two.assignmenttwo.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String error){
        super(error);
    }

}
