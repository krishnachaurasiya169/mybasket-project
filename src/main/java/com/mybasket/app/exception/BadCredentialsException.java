package com.mybasket.app.exception;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException(String message){
        super(message);
    }

    public BadCredentialsException(){
        super("invalid user name or password");
    }
}
