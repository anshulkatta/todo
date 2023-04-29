import React from 'react';
import TodoItemProp from 'src/interfaces/common-interfaces'
import { CheckCircleIcon } from '@heroicons/react/20/solid'
import { ExclamationCircleIcon } from '@heroicons/react/20/solid'
import {GET_PATHS} from 'src/api/paths'

const {POST_MARK_COMPLETE} = GET_PATHS

const ViewTodoItem: React.FC<TodoItemProp> = ({ todoItem }) => {
    const {title, completed} = todoItem

    const toggleComplete = () => {
        fetch(POST_MARK_COMPLETE, {
            method: 'post',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(todoItem.id)
        });
    }

    return (
        <>
            <div className="py-8 px-8 max-w-sm mx-auto bg-white rounded-xl shadow-lg shadow-stone-800/50 
            hover:shadow-sky-800 space-y-2 sm:py-4 sm:flex sm:items-center sm:space-y-0 sm:space-x-6">
                {completed ? <CheckCircleIcon className="h-8 w-8 text-blue-500" /> : <ExclamationCircleIcon className="h-8 w-8 text-rose-500" />}
                    <div className="text-center space-y-2 sm:text-left">
                        <div className="space-y-0.5">
                            <p className="text-lg text-black font-semibold">
                                {title}
                            </p>
                        </div>
                    </div>
                    <button className="px-4 py-1 text-sm text-blue-600 font-semibold rounded-full border border-purple-200 hover:text-white hover:bg-cyan-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-purple-600 focus:ring-offset-2" onClick={toggleComplete}>
                        Complete
                    </button>
            </div>
        </>
    )
}

export default ViewTodoItem