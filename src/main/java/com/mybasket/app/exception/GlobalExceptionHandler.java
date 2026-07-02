package com.mybasket.app.exception;

import com.mybasket.app.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice

//( controllerAdvice  means apply logic at all the globally controller  + Responsebody ) both are in restcontolleradvice aur rest means only data send hoga
public class GlobalExceptionHandler {
@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<ErrorResponse> handleNoSuchElement(NoSuchElementException ex){
    System.out.println("exception are Handled");
    ErrorResponse errorresponse = new ErrorResponse(ex.getMessage() ,HttpStatus.NOT_FOUND,404);
    return new ResponseEntity<>(errorresponse , HttpStatus.NOT_FOUND);
}

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        System.out.println("exception are Handled");
        ErrorResponse errorresponse = new ErrorResponse(ex.getMessage() ,HttpStatus.NOT_FOUND,404);
        return new ResponseEntity<>(errorresponse , HttpStatus.NOT_FOUND);
    }

}
