package com.todo.app.service;

import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import com.todo.app.repo.TodoRepository;
import com.todo.app.util.DtoMapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoServiceTest {

    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @BeforeEach
    public void init() {
        todoService = new TodoService(todoRepository);
    }

    @Test
    public void testCreateTodoItem() {
        TodoItemDto todoItemDto = new TodoItemDto();
        todoItemDto.setTitle("testItem");

        TodoItem todoItem = DtoMapperUtil.convertToEntity(todoItemDto);

        when(todoRepository.save(any())).thenReturn(todoItem);

        assertEquals(todoItem.getDescription(), todoService.createTodoItem(todoItemDto).getDescription());
    }

    @Test
    public void testGetTodoItemById() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("testItem");

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todoItem));

        assertNotNull(todoService.getTodoItemById(1L));
    }

    @Test
    public void testGetAllItems() {
        when(todoRepository.findAll()).thenReturn(new ArrayList<>());

        assertNotNull(todoService.getAllItems());
    }
}
