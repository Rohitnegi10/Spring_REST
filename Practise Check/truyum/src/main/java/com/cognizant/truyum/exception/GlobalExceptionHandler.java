package com.cognizant.truyum.exception;

import com.cognizant.truyum.model.ErrorItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorItem> handleException( MenuItemException exception){

        //Create a POJO of StudentErrorResponse
        ErrorItem buildError = new ErrorItem();

        buildError.setMessage(exception.getMessage()); //Get the message from the thrown exception
        buildError.setStatus(HttpStatus.NOT_FOUND.value()); //Set the error code
        buildError.setTimeStamp(System.currentTimeMillis()); //Set current time stamp

        //ResponseEntity will contain the reference of POJO class that we created and a http status
        //The POJO will be converted into a JSON file by spring - jackson integration
        return new ResponseEntity<>(buildError, HttpStatus.NOT_FOUND);

    }

}