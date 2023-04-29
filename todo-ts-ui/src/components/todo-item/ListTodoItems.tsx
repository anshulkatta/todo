import {GET_PATHS} from 'src/api/paths'
import {useFetch} from 'src/hooks/useFetch'
import TodoItem from 'src/model/TodoItem';
import _ from 'lodash'
import ViewTodoItem from 'src/components/todo-item/ViewTodoItem';
import NoItem from 'src/components/no-item/NoItem';
import Loading from 'src/components/loading/Loading';
import { useState } from 'react';

const {GET_ALL_TODO_ITEMS} = GET_PATHS

export default function ListTodoItems() {
    const [refreshEvent, setRefreshEvent] = useState(false)
    const {data, isLoading} = useFetch<TodoItem>(GET_ALL_TODO_ITEMS, refreshEvent)

    return (
        <> {!isLoading ? !_.isEmpty(data) ? data?.map(item => {
            return (
                <div className='flex items-center'>
                    <div className="flex flex-col pb-5">
                        <ViewTodoItem todoItem={item} setRefreshEvent={setRefreshEvent} />
                    </div>
                </div>
            )
        }) : <NoItem /> : 
        <div className='flex items-center animate-pulse'>
            <Loading />
        </div>}
        </>
    )
}