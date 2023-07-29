package com.example.rest.model;


import com.example.rest.entity.TodoEntity;
import lombok.Data;

@Data
public class Todo {
	private Long id;
	private String title;
	private boolean completed;

	public static Todo toModel(TodoEntity t){
		Todo todo = new Todo();
		todo.setId(t.getId());
		todo.setTitle(t.getTitle());
		todo.setCompleted(t.getCompleted());

		return todo;
	}
}
