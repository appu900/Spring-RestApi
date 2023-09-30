package com.appu.restapi7.Advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException exception){
      Map<String,String> errorMessage = new HashMap<>();
      exception.getBindingResult().getFieldErrors().forEach(error ->{
          errorMessage.put(error.getField(),error.getDefaultMessage());
      });

      return errorMessage;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleUserNotFound(UserNotFoundException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("error",exception.getMessage());
        return  errorMap;
    }
}
