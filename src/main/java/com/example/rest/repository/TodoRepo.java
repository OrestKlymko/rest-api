package com.example.rest.repository;

import com.example.rest.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
