package com.nishant.ctplbackend.DTO.userDto;

import com.nishant.ctplbackend.annotations.FieldMatching;
import com.nishant.ctplbackend.annotations.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@FieldMatching(
        field = "userDtoPassword",
        fieldMatch = "userDtoConfirmPassword",
        message = "Password didn't matched!"
)
@Data
public class UserDto {


    private int userDtoId;

    @NotBlank(message = "Please provide email!")
    @ValidEmail
    private String userDtoEmail;

    @NotBlank(message = "Please provide password!")
    private String userDtoPassword;

    @NotBlank(message = "Please provide User-Name!")
    private String userDtoUserName;

    @NotBlank(message = "Please provide Confirm-password!")
    private String userDtoConfirmPassword;

    @NotBlank(message = "Please provide Phone-Number!")
    @Pattern(regexp = "^9[78]\\d{8}$")
    private String userDtoPhoneNumber;



}
