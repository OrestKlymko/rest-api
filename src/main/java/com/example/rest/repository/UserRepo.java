package com.example.rest.repository;

import com.example.rest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends CrudRepository<UserEntity,Long> {
	UserEntity findByUsername(String username);
}
