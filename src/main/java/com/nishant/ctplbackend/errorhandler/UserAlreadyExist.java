package com.nishant.ctplbackend.errorhandler;

public class UserAlreadyExist extends RuntimeException{

    public UserAlreadyExist(String userAlreadyExistsMsg){
        super(userAlreadyExistsMsg);
    }

}
