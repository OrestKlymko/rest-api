package com.example.rest.controller;


import com.example.rest.entity.TodoEntity;
import com.example.rest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	@PostMapping
	public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long id){
		try {
			return ResponseEntity.ok(todoService.createTodo(todo,id));
		}catch (Exception e){
			return ResponseEntity.badRequest().body("Something wrong...");
		}
	}

	@PutMapping
	public ResponseEntity completeTodo( @RequestParam Long id){
		try {
			return ResponseEntity.ok(todoService.complete(id));
		}catch (Exception e){
			return ResponseEntity.badRequest().body("Something wrong...");
		}
	}
}
