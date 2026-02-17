package com.nishant.ctplbackend.service.userService;


import com.nishant.ctplbackend.DTO.userDto.UserDto;
import com.nishant.ctplbackend.errorhandler.UserAlreadyExist;
import com.nishant.ctplbackend.mapper.UserMapper;
import com.nishant.ctplbackend.model.user.Users;
import com.nishant.ctplbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserMapper userMapper, UserRepo userRepo, PasswordEncoder passwordEncoder){
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean createNewUser(UserDto userDto){

            boolean isSaved = false;

            Optional<Users> alreadyExist = userRepo.findByUserEmail(userDto.getUserDtoEmail());

            if(alreadyExist.isPresent()){
               throw new UserAlreadyExist("User Already Exist!");
            }

            Users user = userMapper.toUserEntity(userDto);
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            Users savedUser = userRepo.save(user);

            if(savedUser.getUserId() > 0){
                isSaved = true;
                return isSaved;
            }
            return isSaved;




    }


}
