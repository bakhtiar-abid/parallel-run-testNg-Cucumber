
@skip
Feature: Registration page feature

  Background:
    Given  user is on registration page

  Scenario: Navigate to registration page
    Given user is on home page
    When user click on my registration page
    And user gets the title of the page
    Then page title should be "Your store. Register"

    Scenario: Unable to register without first name field
      Given user gets the title of the page
      When page title should be "Your store. Register"
      Then user enters last name "Mike"
      * user enters email as "john.mike@gmail.com"
      * user enters phone number "017468484948"
      * user enters fax number "8802385857"
      * user enters password for registration page "123456"
      * user enters confirm password for registration page "123456"
      * user click on registration button
      * user see error message "First name is required."


  Scenario: Unable to register without last name field
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user enters confirm password for registration page "123456"
    * user click on registration button
    * user see error message "Last name is required."


  Scenario: Unable to register without email field
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user enters confirm password for registration page "123456"
    * user click on registration button
    * user see error message "Email is required."

  Scenario: Unable to register without password field
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters confirm password for registration page "123456"
    * user click on registration button
    * user see confirm password error message "The password and confirmation password do not match."


  Scenario: Unable to register without confirm password field
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user click on registration button
    * user see confirm password error message "Password is required."


  Scenario: Unable to register while giving mismatch password
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user enters confirm password for registration page "1234567"
    * user click on registration button
    * user see confirm password error message "The password and confirmation password do not match."

  Scenario: Unable to register giving wrong email
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters wrong email as "john.mike"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user click on registration button
    * user see error message "Wrong email"

  Scenario: Unable to register giving less password length
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "12"
    * user click on registration button
    * user see mismatch error message "must meet the following rules:must have at least 6 characters"


  Scenario: Register with valid credentials
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters email as "john.mike1238@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user enters confirm password for registration page "123456"
    * user click on registration button
    * user should see success message as "Your registration completed"

  Scenario: Register with existing credentials
    Given user gets the title of the page
    When page title should be "Your store. Register"
    Then user enters first name as "Jhon"
    * user enters last name "Mike"
    * user enters exist email as "john.mike@gmail.com"
    * user enters phone number "017468484948"
    * user enters fax number "8802385857"
    * user enters password for registration page "123456"
    * user enters confirm password for registration page "123456"
    * user click on registration button
    * user should see existing error message "The specified email already exists"

