Feature: Payment process

  Scenario Outline: Check if payment declined error is displayed
    Given I am on Ryanair start page
      And I search for a flight from <flightFrom> to <flightTo> on <flightDate>
      And I pick a first offer
      And I do a check out
     When I am trying to do a payment as logged user
      And I insert a valid passenger data
      And I insert a valid contact data
      And I insert payment details with card number '<cardNumber>' and security code '<cardSecurityCode>'
      And I insert a valid billing data
      And I make a payment
     Then I should see payment declined error

    Examples:
      | flightFrom        | flightTo      | flightDate | cardNumber        | cardSecurityCode |
      | Katowice          | Chania        | 09-09-2017 | 5555555555555557  | 265              |


