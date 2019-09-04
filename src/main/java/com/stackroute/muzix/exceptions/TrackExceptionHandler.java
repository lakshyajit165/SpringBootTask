package com.stackroute.muzix.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TrackExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String handleTrackNotFoundException(TrackNotFoundException exception){
        return exception.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    public String handleTrackAlreadyExistsException(TrackAlreadyExistsException exception){
        return exception.getMessage();
    }
}
