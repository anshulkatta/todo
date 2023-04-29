package com.todo.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import com.todo.app.repo.TodoRepository;
import com.todo.app.util.Constants;
import com.todo.app.util.DtoMapperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllTodoItems() throws Exception {
        List<TodoItem> todoItemList = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("testItem");
        todoItemList.add(todoItem);

        when(todoRepository.findAll()).thenReturn(todoItemList);

        List<TodoItemDto> expectedResponse = todoItemList.
                stream().
                map(DtoMapperUtil::convertToDto).
                collect(Collectors.toList());

        this.mockMvc
                .perform(get(Constants.TODO_ENDPOINT + Constants.GET_ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    public void shouldReturnWhenGetTodoItemById() throws Exception {
        TodoItem todoItem = new TodoItem();
        when(todoRepository.findById(1L)).thenReturn(Optional.of(todoItem));

        TodoItemDto todoItemDto = DtoMapperUtil.convertToDto(todoItem);

        this.mockMvc
                .perform(get(Constants.TODO_ENDPOINT + "/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(todoItemDto)));
    }
}
