package com.greenfoxacademy.herokutodo.services;

import com.greenfoxacademy.herokutodo.models.Todo;
import com.greenfoxacademy.herokutodo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceimpl implements ToDoService {

  @Autowired
  ToDoRepository toDoRepository;

  @Override
  public void deleteToDo(Long id) {
    toDoRepository.deleteById(id);
  }

  @Override
  public void changeIsDone(Long id) {
    toDoRepository.findById(id).get().setDone(true);
  }
}
