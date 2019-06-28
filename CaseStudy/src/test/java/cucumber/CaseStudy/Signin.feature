
Feature: Signin

 @Signin
  Scenario Outline: SignIn to TestMe Application
    Given Enter registred user name  "<LoginName>"
    When Enter Password "<values>"
    And Click on submit button
    Then Registred page will be displayed

    Examples: 
      | LoginName    | values      | 
      | lalitha      | password123 |
      
      
    @Search 
   Scenario: Search the product in TestMe application
   Given Enter Product name using four characters
    When Click on the suggested product 
    And Click on find button
    Then Product page will be displayed
