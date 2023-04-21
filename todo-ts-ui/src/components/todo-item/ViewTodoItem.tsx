import React from 'react';
import TodoItemProp from 'src/interfaces/common-interfaces'

const ViewTodoItem: React.FC<TodoItemProp> = ({ todoItem }) => {
    const {title} = todoItem
    return (
        <>
            <div>Todo Item</div>
            <p>{title}</p>
        </>
    )
}

export default ViewTodoItem