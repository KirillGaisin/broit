Feature: As a user, I want to add multiple items to the cart while browsing the shop

  Scenario: Add multiple items to the cart and checkout
    Given browser is opened and Presta shop page is navigated to
    When user selects product
    And product is added to the cart and user continues browsing
    And user selects product
    And product is added to the cart and user checks it out
    And product is checked out from the cart
    And credentials are filled in as first name "testname", last name "testlastname", email "test@broit.com"
    And address is filled in as address 1 "teststr", city "testcity", post code "15243"
    And payment is finalized