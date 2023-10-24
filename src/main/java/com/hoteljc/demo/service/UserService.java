package com.hoteljc.demo.service;
import com.hoteljc.demo.dtos.UserDtoIn;
import com.hoteljc.demo.dtos.UserDtoOut;
import com.hoteljc.demo.models.User;

import java.util.List;

public interface UserService {
    UserDtoOut registerUser(UserDtoIn userDtoIn);
    UserDtoOut findById(Long id);
    List<UserDtoOut> findAll();
    UserDtoOut update(UserDtoIn userDtoIn,Long id);

    String delete(Long id);

    User findByEmail(String email);

}
