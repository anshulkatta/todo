package com.todo.app.repo;

import com.todo.app.model.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoItem, Long> {
}
