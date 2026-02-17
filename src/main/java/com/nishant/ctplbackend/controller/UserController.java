package com.nishant.ctplbackend.controller;


import com.nishant.ctplbackend.DTO.userDto.UserDto;
import com.nishant.ctplbackend.model.Response;
import com.nishant.ctplbackend.service.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerNewUser(@Valid @RequestBody UserDto userDto){

       boolean isCreated = userService.createNewUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("200","User Created successfully!"));
    }


}
