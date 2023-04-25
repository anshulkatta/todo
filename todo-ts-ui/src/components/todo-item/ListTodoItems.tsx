import {GET_PATHS} from 'src/api/paths'
import {useFetch} from 'src/hooks/useFetch'
import TodoItem from 'src/model/TodoItem';
import _ from 'lodash'
import ViewTodoItem from 'src/components/todo-item/ViewTodoItem';

const {GET_ALL_TODO_ITEMS} = GET_PATHS

export default function ListTodoItems() {
    const {data} = useFetch<TodoItem>(GET_ALL_TODO_ITEMS)

    return (
        <>
            {!_.isEmpty(data) ? data?.map(item => {
                return (
                    <div className='flex items-center '>
                        <div className="flex flex-col pb-5">
                            <ViewTodoItem todoItem={item} />
                        </div>
                    </div>
                )
            }) : null}
        </>
    )
}