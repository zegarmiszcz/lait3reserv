Feature: Open mane page and click the links

Scenario: Click on the all available buttons in main menu
Given I open main page
When I click on the "REGISTER" link
When I click on the "SUPPORT" link
When I click on the "CONTACT" link
When I click on the SIGN-ON link
Then system is on SIGN-ON page


Scenario: Login to the newtours page
Given I open main page
When I click on the SIGN-ON link
And I login as "tutorial" with passowrd "tutorial"
Then user is logged in