import ViewTodoItem from 'src/components/todo-item/ViewTodoItem'
import 'src/index.css'

describe('<ViewTodoItem />', () => {
  let todoItem = {
    title: 'test',
    id: 1,
    completed: false,
    description: 'test'
  }

  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<ViewTodoItem todoItem={todoItem} />)
  })
})