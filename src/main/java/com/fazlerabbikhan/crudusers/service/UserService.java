package com.fazlerabbikhan.crudusers.service;

import com.fazlerabbikhan.crudusers.entity.UserEntity;
import com.fazlerabbikhan.crudusers.model.response.UserResponse;

public interface UserService {

    UserEntity createUser(UserEntity userEntity);
    UserResponse getUserById(long id);
    UserResponse updateUser(long id, UserEntity userEntity);
    String deleteUser(long id);
}