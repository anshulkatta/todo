package com.todo.app.service;

import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import com.todo.app.repo.TodoRepository;
import com.todo.app.util.DtoMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoItem createTodoItem(TodoItemDto todoItemDto) {
        return todoRepository.save(DtoMapperUtil.convertToEntity(todoItemDto));
    }

    public TodoItem getTodoItemById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Iterable<TodoItem> getAllItems() {
        return todoRepository.findAll();
    }
}
