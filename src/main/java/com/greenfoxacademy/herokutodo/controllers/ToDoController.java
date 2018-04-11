package com.greenfoxacademy.herokutodo.controllers;

//Create a new controller called TodoController which maps to /todo
//        Add a single public String list(Model model) method which maps to / and /list in the controller, which returns with "This is my first todo" string. Use the @Responsebody annotation.
//        Run the application. If all works fine, we can go ahead.

import com.greenfoxacademy.herokutodo.models.Todo;
import com.greenfoxacademy.herokutodo.repositories.ToDoRepository;
import com.greenfoxacademy.herokutodo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ToDoController {

  @Autowired
  ToDoRepository toDoRepository;
  @Autowired
  ToDoService toDoService;

  @GetMapping(value = {"/", "/list"})
  public String list(@RequestParam(value = "isActive", required = false) boolean isDone, Model model) {
    model.addAttribute("todos", toDoRepository.findAll());
    model.addAttribute("isActive", isDone);
    return "todo";
  }

  @GetMapping(value = "/add")
  public String toDoForm() {
    return "add";
  }

  @PostMapping(value = "/add")
  public String toDoSubmit(@ModelAttribute(value = "todotitle") String title) {
    toDoRepository.save(new Todo(title));
    return "redirect:/list";
  }

  @GetMapping(value = "/{id}/delete")
  public String delete(@PathVariable Long id){
    toDoService.deleteToDo(id);
    return "redirect:/list";
  }
}
