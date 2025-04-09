Feature: Test of BasketballEngland

  Scenario Outline: I Create an account
    Given I am at BasketballEngland page using "<browser>"
    When I create an account
    Then The account is successfully created
    And We see our account page "https://membership.basketballengland.co.uk/Home/Index"
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario: Create error message (name)
    Given I am at BasketballEngland page
    When I enter my name "Test"
    And I enter my lastname "!\"€"
    Then The "Invalid Value - Allowed characters: A-Z, space and '/\&.-" is displayed

  Scenario: Create error message (password)
    Given I am at BasketballEngland page
    When I enter my password "ööö123"
    And I confirm my password "äää456"
    Then The "Password did not match" is displayed

  Scenario: Create error message (email)
    Given I am at BasketballEngland page
    When I enter my email "scoobydoo@mysterywagon.com"
    And I confirm my email "scrappydoo@mysterywagon.com"
    Then The "Confirm Email Address does not match" is displayed

  Scenario:
    Given I am at BasketballEngland page
    When I create an account without accepting terms and conditions
    Then The "You must confirm that you have read, understood and agree to the Code of Ethics and Conduct" is displayed


