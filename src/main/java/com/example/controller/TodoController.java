package com.example.controller;

import com.example.domain.Todo;
import com.example.domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todo> all() {
        return todoRepository.findAll();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Todo save(@Validated @RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable Long id) {
        todoRepository.delete(id);

        return null;
    }

}
