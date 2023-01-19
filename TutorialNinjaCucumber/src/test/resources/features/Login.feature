
Feature: Login functionality

Scenario Outline: Login with valid credentials

Given User has navigate to login page
When User has enter valid email address <UserName> into email field
And user has enter valid password  <Password> into password field
And user click on login button
Then user should get successfully logged in 

Examples:
|UserName              |Password|
|amotooricap9@gmail.com|12345   |
|amotooricap1@gmail.com|12345   |




Scenario: Login with invalid credentials

Given User has navigate to login page
When User has enter Invalid email address  into email field
And user has enter Invalid password  "1234345235" into password field
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with valid Email and invalid password

Given User has navigate to login page
When User has enter valid email address "amotooricap9@gmail.com" into email field
And user has enter Invalid password  "1234345235" into password field
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with invalid Email and valid password

Given User has navigate to login page
When User has enter Invalid email address  into email field
And user has enter valid password  "12345" into password field
And user click on login button
Then user should get a proper warning message about credentials mismatch

Scenario: login without any credentials

Given User has navigate to login page
When user dont enter any email address into email field
And user dont enter any password into password field
And user click on login button
Then user should get a proper warning message about credentials mismatch




