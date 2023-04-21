package com.todo.app.service;

import com.todo.app.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public void createTodoItem() {
        // call Repo
    }

    public TodoItem getTodoItemById(Long id) {
        // get by Id
        return new TodoItem();
    }
}
