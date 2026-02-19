package com.nishant.ctplbackend.DTO.userDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDto {

    @NotBlank(message = "Please provide the role-name!")
    private String roleName;


}
