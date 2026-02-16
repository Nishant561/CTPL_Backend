package com.nishant.ctplbackend.mapper;


import com.nishant.ctplbackend.DTO.userDto.UserDto;
import com.nishant.ctplbackend.model.user.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {






    @Mapping(source = "userDtoEmail", target = "userEmail")
    @Mapping(source="userDtoUserName", target = "userName")
    @Mapping(source ="userDtoPassword", target = "userPassword")
    @Mapping(source = "userDtoPhoneNumber", target = "userPhoneNumber")
    Users toUserEntity(UserDto userDto);


    @Mapping(source = "userId", target = "userDtoId" , defaultValue = "1")
    @Mapping(source = "userEmail", target = "userDtoEmail")
    @Mapping(source="userName", target = "userDtoUserName")
    @Mapping(source ="userPassword", target = "userDtoPassword")
    @Mapping(source = "userPhoneNumber", target = "userDtoPhoneNumber")
    UserDto toUserDto(Users users);



}
