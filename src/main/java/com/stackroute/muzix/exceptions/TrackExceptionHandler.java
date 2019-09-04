package com.stackroute.muzix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class TrackExceptionHandler {

    HashMap<String, Object> responseObject;

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> handleTrackNotFoundException(TrackNotFoundException exception){
        responseObject = new HashMap<>();
        responseObject.put("result", null);
        responseObject.put("msg", exception.getMessage());
        responseObject.put("error", "true");
        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> handleTrackAlreadyExistsException(TrackAlreadyExistsException exception){
        responseObject = new HashMap<>();
        responseObject.put("result", null);
        responseObject.put("msg", exception.getMessage());
        responseObject.put("error", "true");
        return new ResponseEntity<>(responseObject, HttpStatus.CONFLICT) ;
    }
}
