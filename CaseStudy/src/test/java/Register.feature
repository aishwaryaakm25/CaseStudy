
Feature: TestMe Application

  @TestMe
  Scenario: regitration for testMe application
    Given Enter to Signup page
    When Enter the required details
    | UserName     | FirstName | LastName| Password   |ConPassword| Email           |MobileNum    | Address | 
    | Username007  | User      | Name    | pass123    | pass123   | a.b@gmail.com   | 9962453595  | Chennai | 
    And Click on register button
    
    