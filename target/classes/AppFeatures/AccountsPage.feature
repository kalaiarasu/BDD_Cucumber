Feature: Account Page feature

Background:
Given user has already logged into application
|username|password|
|test3211@test.com|Test123#|

@accounts
Scenario: Account page title
Given user is on a Accounts page
When users gets the title of the page
Then page tiltle should be "My account - My Shop"

@accounts
Scenario: Account section count
Given user is on a Accounts page
Then user gets accounts section
|ADD MY FIRST ADDRESS|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|Home|
And accounts section count should be 6

  