import ListTodoItems from 'src/components/todo-item/ListTodoItems'
import 'src/index.css'

describe('<ListTodoItems />', () => {
  beforeEach(function () {
    cy.intercept(
      {
        method: 'GET',
        url: '/todo/getAllItems', 
      },
      [{title: 'todo 1'}]
    ).as('getAllItems')
  })

  it('renders', () => {
    cy.mount(<ListTodoItems />)
  })
})