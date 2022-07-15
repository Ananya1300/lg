package com.lg.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lg.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
