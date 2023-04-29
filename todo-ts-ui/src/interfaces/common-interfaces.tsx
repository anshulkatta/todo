import TodoItem from 'src/model/TodoItem'

export default interface ViewTodoItemProp {
  todoItem: TodoItem,
  setRefreshEvent: Function
}