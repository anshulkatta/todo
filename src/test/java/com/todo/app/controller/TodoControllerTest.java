package com.todo.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.model.TodoItem;
import com.todo.app.service.TodoService;
import com.todo.app.util.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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
    private TodoService todoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllTodoItems() throws Exception {
        List<TodoItem> todoItemList = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("testItem");
        todoItemList.add(todoItem);

        when(todoService.getAllItems()).thenReturn(todoItemList);

        this.mockMvc
                .perform(get(Constants.TODO_ENDPOINT + Constants.GET_ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(todoItemList)));
    }


}
