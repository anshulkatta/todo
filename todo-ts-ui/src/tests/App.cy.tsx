import 'src/index.css'
import App from 'src/App';

describe('<App />', () => {
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
    cy.mount(<App />)
  })
})
