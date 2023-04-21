import ViewTodoItem from 'src/components/todo-item/ViewTodoItem'

export default function TodoBrowser() {
    const obj = {title: 'test'}
    return (
        <>
            <ViewTodoItem
                todoItem={obj} />
        </>
    )
}