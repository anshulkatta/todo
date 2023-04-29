import Loading from 'src/components/loading/Loading';
import 'src/index.css'

describe('Loading', () => {
    beforeEach(function () {
      cy.intercept(
        {
          method: 'GET',
          url: '/todo/getAllItems', 
        },
        []
      ).as('getAllItems')
    })
  
    it('renders', () => {
      cy.mount(<Loading />)
    })
  })