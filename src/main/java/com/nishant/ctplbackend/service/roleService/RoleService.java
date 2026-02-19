package com.nishant.ctplbackend.service.roleService;


import com.nishant.ctplbackend.DTO.userDto.RoleDto;
import com.nishant.ctplbackend.enums.RoleEnums;
import com.nishant.ctplbackend.errorhandler.UserAlreadyExist;
import com.nishant.ctplbackend.mapper.RoleMapper;
import com.nishant.ctplbackend.model.user.Roles;
import com.nishant.ctplbackend.repo.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
     private final RoleRepo roleRepo;
    private final RoleMapper roleMapper;

     public RoleService(RoleRepo roleRepo, RoleMapper roleMapper){
         this.roleRepo = roleRepo;
         this.roleMapper = roleMapper;
     }

    public boolean createNewRole(RoleDto roleDto){
        boolean isCreated = false;



         roleDto.setRoleName("ROLE_" + roleDto.getRoleName().toUpperCase());
        RoleEnums roleEnums = RoleEnums.valueOf(roleDto.getRoleName());
     Optional<Roles> foundRole = roleRepo.findByRoleName(roleEnums);

     foundRole.ifPresent(
             roles -> {

                 throw new UserAlreadyExist("Role already exist!");
             }
     );

        Roles role = roleMapper.toRoleEntity(roleDto);

        Roles savedRole = roleRepo.save(role);

        if ( null != savedRole && savedRole.getRoleId()> 0){
            isCreated = true;
            return isCreated;
        }

        return isCreated;


    }

}
