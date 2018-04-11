package com.greenfoxacademy.herokutodo.services;


public interface ToDoService {
  void deleteToDo(Long id);
  void changeIsDone(Long id);
}
