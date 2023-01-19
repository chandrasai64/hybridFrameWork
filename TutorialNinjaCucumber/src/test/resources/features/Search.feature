Feature: Search functionality

Scenario: user searches for a valid product

Given user opens application
When user enter valid product "HP" into search box field
And user click on search button
Then user should get valid product displayed in search results

Scenario: user searches for a invalid product

Given user opens application
When user enter invalid product "HPo" into search box field
And user click on search button
Then user should get a message aboout no product matching

Scenario: user searches without any product

Given user opens application
When user dont enter any product name into search box field
And user click on search button
Then user should get a message aboout no product matching
