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
        todoItem.setTitle("Todo Item 1");
        todoItem.setCompleted(false);
        todoItems.add(todoItem);

        TodoItem todoItem2 = new TodoItem();
        todoItem2.setTitle("Todo Item 2");
        todoItem2.setCompleted(true);
        todoItems.add(todoItem2);

        return todoItems;
    }
}
