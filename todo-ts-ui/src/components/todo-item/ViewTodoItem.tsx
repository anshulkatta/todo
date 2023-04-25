import React from 'react';
import TodoItemProp from 'src/interfaces/common-interfaces'
import { CheckCircleIcon } from '@heroicons/react/20/solid'

const ViewTodoItem: React.FC<TodoItemProp> = ({ todoItem }) => {
    const {title} = todoItem
    return (
        <>
            <div className="py-8 px-8 max-w-sm mx-auto bg-white rounded-xl shadow-lg shadow-cyan-800/50 space-y-2 sm:py-4 sm:flex sm:items-center sm:space-y-0 sm:space-x-6">
                <CheckCircleIcon className="h-8 w-8 text-blue-500" />
                    <div className="text-center space-y-2 sm:text-left">
                        <div className="space-y-0.5">
                            <p className="text-lg text-black font-semibold">
                                {title}
                            </p>
                        </div>
                    </div>
                    <button className="px-4 py-1 text-sm text-blue-600 font-semibold rounded-full border border-purple-200 hover:text-white hover:bg-cyan-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-purple-600 focus:ring-offset-2">
                        Complete
                    </button>
            </div>
        </>
    )
}

export default ViewTodoItem