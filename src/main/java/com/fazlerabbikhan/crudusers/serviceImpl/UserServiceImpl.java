package com.fazlerabbikhan.crudusers.serviceImpl;

import com.fazlerabbikhan.crudusers.entity.UserEntity;
import com.fazlerabbikhan.crudusers.model.response.UserResponse;
import com.fazlerabbikhan.crudusers.repository.UserRepository;
import com.fazlerabbikhan.crudusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserResponse getUserById(long id) {
       UserEntity userEntity = userRepository.findById(id);
        UserResponse userResponse = new UserResponse();
        if (userEntity != null) {
            userResponse.setOutCode("1");
            userResponse.setOutMessage("User found successfully" );
            userResponse.setId(userEntity.getId());
            userResponse.setName(userEntity.getName());
            userResponse.setUsername(userEntity.getUsername());
            userResponse.setEmail(userEntity.getEmail());
            userResponse.setPhone(userEntity.getPhone());
            userResponse.setAddress(userEntity.getAddress());
        } else {
            userResponse.setOutCode("0");
            userResponse.setOutMessage("User doesn't exist with ID " + id);
        }
        return userResponse;
    }

    @Override
    public UserResponse updateUser(long id, UserEntity userEntity) {
        UserEntity existingUser = userRepository.findById(id);
        UserResponse userResponse = new UserResponse();
        if (existingUser != null) {
            existingUser.setName(userEntity.getName());
            existingUser.setUsername(userEntity.getUsername());
            existingUser.setEmail(userEntity.getEmail());
            existingUser.setPhone(userEntity.getPhone());
            existingUser.setAddress(userEntity.getAddress());
            userRepository.save(existingUser);

            userResponse.setOutCode("1");
            userResponse.setOutMessage("User updated successfully");
            userResponse.setId(existingUser.getId());
            userResponse.setName(existingUser.getName());
            userResponse.setUsername(existingUser.getUsername());
            userResponse.setEmail(existingUser.getEmail());
            userResponse.setPhone(existingUser.getPhone());
            userResponse.setAddress(existingUser.getAddress());
        } else {
            userResponse.setOutCode("0");
            userResponse.setOutMessage("User doesn't exist with ID " + id);
        }
        return userResponse;
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

}
