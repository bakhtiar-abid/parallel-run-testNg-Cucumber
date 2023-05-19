Feature: Account Page Feature

  Background:
    Given user has already logged in to application
      |username|password|
      |latexaid@gmail.com|123456|

  @accounts
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "Your store. Account"

  @accounts
  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      |Customer info|
      |Addresses|
      |Orders|
      |CyberSource payment tokens|
      |Return requests|
      |Downloadable products|
      |Back in stock subscriptions|
      |Reward points|
      |Change password|
      |My product reviews|
    And accounts section count should be 10