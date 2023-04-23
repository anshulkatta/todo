package com.todo.app.service;

import com.todo.app.model.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public void createTodoItem() {
        // call Repo
    }

    public TodoItem getTodoItemById(Long id) {
        // get by Id
        return new TodoItem();
    }

    public Iterable<TodoItem> getAllItems() {
        List<TodoItem> todoItems = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("Todo 1");
        todoItems.add(todoItem);
        return todoItems;
    }
}
