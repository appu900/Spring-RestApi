package com.appu.restapi7.Advice;

public class UserNotFoundException extends Exception {



    public UserNotFoundException(String errorMessage){
        super(errorMessage);
    }


}
