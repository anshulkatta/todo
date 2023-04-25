import {GET_PATHS} from 'src/api/paths'
import {useFetch} from 'src/hooks/useFetch'
import TodoItem from 'src/model/TodoItem';
import _ from 'lodash'
import ViewTodoItem from 'src/components/todo-item/ViewTodoItem';

const {GET_ALL_TODO_ITEMS} = GET_PATHS

export default function ListTodoItems() {
    const {data, isLoading, error} = useFetch<TodoItem>(GET_ALL_TODO_ITEMS)

    return (
        <>
            {!_.isEmpty(data) ? data?.map(item => {
                return (<ViewTodoItem todoItem={item} />)
            }) : null}
        </>
    )
}