package com.todo.app.controller;

import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import com.todo.app.service.TodoService;
import com.todo.app.util.Constants;
import com.todo.app.util.DtoMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(Constants.TODO_ENDPOINT)
public class TodoController {

    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(Constants.CREATE_ITEM)
    public ResponseEntity<String> createTodoItem(@RequestBody TodoItemDto todoItemDto) {
        TodoItem todoItem = todoService.createTodoItem(todoItemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/todo/" + todoItem.getId())
                .body(Constants.SUCCESS);
    }


    @GetMapping(Constants.GET_BY_ID)
    public ResponseEntity<TodoItemDto> getTodoItemById(@PathVariable Long id) {
        TodoItem todoItem = todoService.getTodoItemById(id);
        return todoItem != null ? ResponseEntity.ok(DtoMapperUtil.convertToDto(todoItem)) :  ResponseEntity.notFound().build();
    }

    @GetMapping(Constants.GET_ALL)
    public ResponseEntity<List<TodoItemDto>> getAllTodoItems() {
        Iterable<TodoItem> todoItems = todoService.getAllItems();
        return ResponseEntity.ok(
                StreamSupport.stream(todoItems.spliterator(), false).
                        map(DtoMapperUtil::convertToDto).collect(Collectors.toList())
        );
    }

}
