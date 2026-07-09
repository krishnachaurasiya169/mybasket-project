package com.mybasket.app.exception;

import com.mybasket.app.dto.BadExceptionDto;
import com.mybasket.app.dto.ErrorResponse;
import com.mybasket.app.dto.ValidationErrorResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
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
        ErrorResponse errorresponse = new ErrorResponse(ex.getMessage() , HttpStatus.NOT_FOUND,404);
        return new ResponseEntity<>(errorresponse , HttpStatus.NOT_FOUND);
    }


//   handle  MethodArgumentNotValidException
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<List<ValidationErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    System.out.println("exception handled");
//  FieldError fieldError = ex.getBindingResult().getFieldError();
//  var fieldName=fieldError.getField();
//  var fieldMessage=fieldError.getDefaultMessage();
    List<ValidationErrorResponse> fieldErrorList = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> new ValidationErrorResponse(error.getField(), error.getDefaultMessage()))
            .toList();
    return new ResponseEntity<>(fieldErrorList, HttpStatus.BAD_REQUEST);
}


    //exception ko handle karni hai :
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        System.out.println("Exception are handled");
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<BadExceptionDto> handleBadCredentialsException(BadCredentialsException ex){

    BadExceptionDto badExDto = new BadExceptionDto(ex.getMessage(),HttpStatus.UNAUTHORIZED.value(),System.currentTimeMillis());

    return new ResponseEntity<>(badExDto,HttpStatus.UNAUTHORIZED);

    }


}
