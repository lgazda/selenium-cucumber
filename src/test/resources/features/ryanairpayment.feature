Feature: Payment process

  Scenario: Check if payment declined error is displayed
    Given I am on Ryanair start page
      And I search for a flight from Katowice to Chania on 09-09-2017
      And I pick a first offer
      And I do a check out
     When I am trying to do a payment as logged user
      And I insert a valid passenger data
      And I insert a valid contact data
      And I insert payment details with card number '5555555555555557' and security code '265'
      And I insert a valid billing data
      And I make a payment
     Then I should see payment declined error


