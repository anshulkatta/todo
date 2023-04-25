export default class TodoItem {
    id: number
    title: string
    description: string
    completed: boolean

    constructor(title: string, id: number, description: string, completed: boolean) {
        this.title = title
        this.id = id
        this.description = description
        this.completed = completed
    }
}