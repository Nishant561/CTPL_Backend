package com.nishant.ctplbackend.service.userService;


import com.nishant.ctplbackend.DTO.userDto.UserDto;
import com.nishant.ctplbackend.mapper.UserMapper;
import com.nishant.ctplbackend.model.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    public Users createNewUser(UserDto userDto){

        return userMapper.toUserEntity(userDto);

    }


}
