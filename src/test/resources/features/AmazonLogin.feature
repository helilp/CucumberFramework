#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Amazon Login
  I want to be able to login with valid credentials.
  I sould not be logged in with invalid credentials.

  @amazonLogin @SmokeTests
  Scenario: User should be directed to log in page
  Given I am on amazon home page
  And The sign in button displays
  When I click on the sign in button
  Then I should be directed to log in page
   
  @amazonLogin @amazonInvalidUser @SmokeTests
  Scenario: User should not be directed to password field when invalid email is given 
  Given I am on the login page
  When I enter invalid email "jon.dow@gmail.com"
  And I click the continue button
  Then I should get error message says "We cannot find an account with that email address" 
  And I should still in the log in page
   
   
   
   
