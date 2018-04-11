package com.greenfoxacademy.herokutodo.repositories;

import com.greenfoxacademy.herokutodo.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo, Long> {
}
