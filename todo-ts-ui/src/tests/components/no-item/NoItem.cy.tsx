import NoItem from 'src/components/no-item/NoItem';
import 'src/index.css'

describe('NoItem', () => {
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
      cy.mount(<NoItem />)
    })
  })