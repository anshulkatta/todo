package com.todo.app.controller;

import com.todo.app.model.TodoItem;
import com.todo.app.service.TodoService;
import com.todo.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.TODO_ENDPOINT)
public class TodoController {

    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(Constants.CREATE_ITEM)
    public ResponseEntity<String> createTodoItem(@RequestBody TodoItem todoItem) {
        todoService.createTodoItem();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/todo/" + todoItem.getId())
                .body(Constants.SUCCESS);
    }


    @GetMapping(Constants.GET_BY_ID)
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        TodoItem todoItem = todoService.getTodoItemById(id);
        return todoItem != null ? ResponseEntity.ok(todoItem) :  ResponseEntity.notFound().build();
    }

    @GetMapping(Constants.GET_ALL)
    public ResponseEntity<Iterable<TodoItem>> getAllTodoItems() {
        return ResponseEntity.ok(todoService.getAllItems());
    }

}
