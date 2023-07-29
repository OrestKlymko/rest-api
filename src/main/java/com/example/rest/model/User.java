package com.example.rest.model;


import com.example.rest.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
	private Long id;
	private String username;
	private List<Todo> todos;
	public static User toModel(UserEntity userEntity){
		User model = new User();
		model.setId(model.getId());
		model.setId(model.getId());
		model.setTodos(userEntity.getTodoList().stream().map(Todo::toModel).collect(Collectors.toList()));
		return model;
	}
}
