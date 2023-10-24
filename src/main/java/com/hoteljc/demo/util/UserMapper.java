package com.hoteljc.demo.util;

import com.hoteljc.demo.dtos.UserDtoIn;
import com.hoteljc.demo.dtos.UserDtoOut;
import com.hoteljc.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserMapper {

    public User convertToEntity(UserDtoIn userDtoIn) {
        User user = new User();
        user.setName(userDtoIn.getName());
        user.setCpf(userDtoIn.getCpf());
        user.setEmail(userDtoIn.getEmail());
        return user;
    }
    public UserDtoOut convertToDtoOut(User user) {
        return new UserDtoOut(user);
    }

    public List<UserDtoOut> toUserDto(List<User> userList) {
        return userList.stream().map(UserDtoOut::new).collect(Collectors.toList());
    }

    public void updateUser(User user, UserDtoIn userDtoIn){
       user.setName(userDtoIn.getName());
       user.setCpf(userDtoIn.getCpf());
    }
}
