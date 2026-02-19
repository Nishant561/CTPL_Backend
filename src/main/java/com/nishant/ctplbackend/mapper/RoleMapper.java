package com.nishant.ctplbackend.mapper;

import com.nishant.ctplbackend.DTO.userDto.RoleDto;
import com.nishant.ctplbackend.enums.RoleEnums;
import com.nishant.ctplbackend.model.user.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RoleMapper {



    RoleDto toRoleDto(Roles roles);


    @Mapping(source = "roleName", target = "roleName", qualifiedByName = "stringToRoleName")
    Roles toRoleEntity(RoleDto roleDto);

    @Named("stringToRoleName")
    default RoleEnums stringToRoleEnums(String roleName){
        return RoleEnums.valueOf(roleName);
    }


}
