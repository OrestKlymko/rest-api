package com.example.rest.service;


import com.example.rest.entity.TodoEntity;
import com.example.rest.entity.UserEntity;
import com.example.rest.model.Todo;
import com.example.rest.repository.TodoRepo;
import com.example.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	@Autowired
	TodoRepo todoRepo;
	@Autowired
	UserRepo userRepo;

	public Todo createTodo(TodoEntity todo,Long id){
		UserEntity userEntity = userRepo.findById(id).get();
		todo.setUser(userEntity);
		return Todo.toModel(todoRepo.save(todo));
	}

	public Todo complete(Long id){
	TodoEntity todo = todoRepo.findById(id).get();
	todo.setCompleted(!todo.getCompleted());
		return Todo.toModel(todoRepo.save(todo));
	}
}
