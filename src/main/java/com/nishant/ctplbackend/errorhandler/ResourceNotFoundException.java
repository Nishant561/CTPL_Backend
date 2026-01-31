package com.nishant.ctplbackend.errorhandler;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
            super(message);
    }
}
