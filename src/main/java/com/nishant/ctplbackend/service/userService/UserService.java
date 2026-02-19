package com.nishant.ctplbackend.service.userService;


import com.nishant.ctplbackend.DTO.userDto.UserDto;
import com.nishant.ctplbackend.enums.RoleEnums;
import com.nishant.ctplbackend.errorhandler.ResourceNotFoundException;
import com.nishant.ctplbackend.errorhandler.UserAlreadyExist;
import com.nishant.ctplbackend.mapper.UserMapper;
import com.nishant.ctplbackend.model.user.Roles;
import com.nishant.ctplbackend.model.user.Users;
import com.nishant.ctplbackend.repo.RoleRepo;
import com.nishant.ctplbackend.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    @Autowired
    public UserService(UserMapper userMapper, UserRepo userRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo){
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
    }


    public boolean createNewUser(UserDto userDto){

            boolean isSaved = false;

            Optional<Users> alreadyExist = userRepo.findByUserEmail(userDto.getUserDtoEmail());

            alreadyExist.ifPresent(user -> {
                throw new UserAlreadyExist("User already Exist!");
            });

            Users user = userMapper.toUserEntity(userDto);
        RoleEnums roleToBeSetForNewUser = RoleEnums.valueOf("ROLE_USER");
        Roles role = roleRepo.findByRoleName(roleToBeSetForNewUser).orElseThrow(()-> new ResourceNotFoundException("Unable to find ROlE_USER!"));

        user.getUserRole().add(role);


            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            Users savedUser = userRepo.save(user);

            if(savedUser.getUserId() > 0){
                isSaved = true;
                return isSaved;
            }
            return isSaved;




    }

    @Transactional
    public void deleteUser(String userEmail){

        Users user = userRepo.findByUserEmail(userEmail).orElseThrow(()-> new UsernameNotFoundException("Given username didn't found!"));

        try{
            userRepo.deleteByUserEmail(userEmail);
        }catch (Exception e){
            throw new RuntimeException("Unable to delete account: " +e.getMessage());
        }

    }

}
