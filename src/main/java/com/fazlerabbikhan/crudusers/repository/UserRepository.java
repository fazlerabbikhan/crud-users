package com.fazlerabbikhan.crudusers.repository;

import com.fazlerabbikhan.crudusers.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findById(long id);
    void deleteById(long id);
}