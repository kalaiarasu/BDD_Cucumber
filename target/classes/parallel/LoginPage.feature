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
@login
Feature: Login Page Feature
  I want to use this template for my feature file

@smoke
  Scenario: Login Page Title
    Given users is on login page
    When users gets the title of the page
    Then page tiltle should be "Login - My Shop"
  @smoke  
  Scenario: Forgot Passowrd Link
    Given users is on login page
    Then forgot your password link should be displayed
   @Regression @Skip 
  Scenario: Login with correct credentials
     Given users is on login page
     When user enter username "test3211@test.com"
     When user enter password "Test123#"
     And user click on Login buttton
     And users gets the title of the page
     Then page tiltle should be "My account - My Shop"
  


 