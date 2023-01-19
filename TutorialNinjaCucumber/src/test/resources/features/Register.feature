
Feature: Registration functionality

Scenario: User creates an account only with mandatory field

Given User has navigate to Register Account page
When User enter the details below field
|firstName|Chandrac              |
|lastName |Bhanuc								|
|telephone|1234567890						|
|password |123456								|
And user select privacy policy
And user click on continue button
Then user account should get created successfully


Scenario: User creates an account with All field

Given User has navigate to Register Account page
When User enter the details below field
|firstName|Chandraa              |
|lastName |Bhanua								|
|telephone|1234567890						|
|password |123456								|
And user select news letter option
And user select privacy policy
And user click on continue button
Then user account should get created successfully

Scenario: User creates a duplicate account 

Given User has navigate to Register Account page
When User enter the details below field with duplicate email
|firstName|Chandra              |
|lastName |Bhanu								|
|email    |chandra98@gmail.com|
|telephone|1234567890						|
|password |123456								|
And user select news letter option
And user select privacy policy
And user click on continue button
Then user should get proper warning about duplicate email

Scenario: User creates an account without filling any details

Given User has navigate to Register Account page
When user dont enter any details into fields

And click on continue button
Then user should get proper warning message for every mandatory fields


