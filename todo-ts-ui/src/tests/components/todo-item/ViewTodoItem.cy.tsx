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
    cy.mount(<ViewTodoItem todoItem={todoItem} />)
  })

  it('mark complete item', ()=> {
    cy.mount(<ViewTodoItem todoItem={todoItem} />)
    cy.get('button')
      .contains('Complete')
      .click() 
  })
})