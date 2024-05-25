@Home
Feature: Home page feature

Background:
Given user is already on login page
|Username|Password|
|standard_user|secret_sauce|

@Smoke
Scenario: Home page title
When user gets the title of the Homepage
Then page title should be "Swag Labs"

@Regression @Skip
Scenario: Selecting the Product
Given user is on Product page
When user selects the Product
And user enters the Add to cart 
And user clicks on cart button
Then user verify the product and click on checkout
