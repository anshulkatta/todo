package com.todo.app.util;

import com.todo.app.dto.TodoItemDto;
import com.todo.app.model.TodoItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static TodoItemDto convertToDto(TodoItem todoItem) {
        return modelMapper.map(todoItem, TodoItemDto.class);
    }

    public static TodoItem convertToEntity(TodoItemDto todoItemDto) {
        return modelMapper.map(todoItemDto, TodoItem.class);
    }
}
