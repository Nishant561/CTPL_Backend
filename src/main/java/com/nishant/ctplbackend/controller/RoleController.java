package com.nishant.ctplbackend.controller;


import com.nishant.ctplbackend.DTO.userDto.RoleDto;
import com.nishant.ctplbackend.model.Response;
import com.nishant.ctplbackend.service.roleService.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("/add-roles")
    public ResponseEntity<Response> addNewRoles(@Valid @RequestBody RoleDto roleDto){
        boolean isAdded = roleService.createNewRole(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("200", "Role Added Successfully!"));
    }

}
