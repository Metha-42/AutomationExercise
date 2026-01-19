Feature: Login functionality

  As a registered user
  I want to login and logout
  So that I can access my account securely

 Background:
	And  User Click the signUp/Login button
	
  Scenario: Verify user login with valid credentials
    When user enters valid email and password as "antoniodas420@gmail.com" and "PAss123@"
    And user clicks on Login button
    
    Then  username should be displayed on the home page

 
  Scenario: Login with invalid password
    When user enters valid email and invalid password as "antoniodas420@gmail.com" and "invalid"
    And user click on Login button
    Then error message should be displayed
    

  Scenario: Login with empty credentials
   When user clicks on Login button without entering credentials
    Then validation message should be displayed
