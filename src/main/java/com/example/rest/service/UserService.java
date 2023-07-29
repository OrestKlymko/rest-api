package com.example.rest.service;


import com.example.rest.entity.UserEntity;
import com.example.rest.exception.UserAlreadyExistException;
import com.example.rest.exception.UserNotFoundException;
import com.example.rest.model.User;
import com.example.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public void registration(UserEntity user) throws UserAlreadyExistException {
		if(userRepo.findByUsername(user.getUsername())!=null) {
			throw new UserAlreadyExistException("User with provided username already exist");
		}
		userRepo.save(user);
	}

	public User getOne(Long id) throws UserNotFoundException {
		UserEntity userEntity = userRepo.findById(id).get();
		if(userEntity==null){
			throw new UserNotFoundException("User not found");
		}
		return User.toModel(userEntity);
	}

	public User deleteUser(Long id) throws UserNotFoundException {
		UserEntity userEntity = userRepo.findById(id).get();
		if(userEntity==null){
			throw new UserNotFoundException("User not found");
		}
		userRepo.deleteById(id);
		return User.toModel(userEntity);
	}
}
