package com.todo.app.util;

import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DtoMapperUtilTest {

    @Test
    public void testConvertToDto() {
        assertNotNull(DtoMapperUtil.convertToDto(new TodoItem()));
    }

    @Test
    public void testConvertToEntity() {
        assertNotNull(DtoMapperUtil.convertToEntity(new TodoItemDto()));
    }
}
