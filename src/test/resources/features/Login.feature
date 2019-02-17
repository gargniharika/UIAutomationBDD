@LoginValidation @Sanity
Feature: User Registration
In order to perform successful Registration
As a user
I want to enter correct email address

Scenario Outline: Validate successful user registration
    Given I am on the Home Page of UIAutomation "http://automationpractice.com/index.php"
    When I go to the Login Page 
    And enter the "<valid>" email address
    And Click on Create an account button
    Then I should see the heading "YOUR PERSONAL INFORMATION" 
Examples:
  | valid              | 
  | abngc@xyz.com   |
  | bnf@ddg.com | 	
  
   
Scenario Outline: Validate unsuccessful user registration
    Given I am on the Home Page of UIAutomation "http://automationpractice.com/index.php"
    When I go to the Login Page 
    And enter the "<invalid>" email address
    And Click on Create an account button
    Then I should see the error as "Invalid email address."   

Examples:
  | invalid              | 
  | abc   | 
  | xyz% |
    