@tag
 Feature: Add to Cart

  

  @AddToCartFail
   Scenario Outline: Fail
    Given Signin the pages "<Loginusername>" and "<Loginpassword>"
     When search the products headphone
     And Try to pay without add that item
     Then Testme don't display that icon
     Examples:
     |Loginusername    |Loginpassword   |
     |lalitha          |password123     |
    

   @AddToCartPass
    Scenario Outline: Pass
     Given Signin the pages Login "<Loginusername1>" and "<Loginpassword1>"
     When search the product in headphone
     And add the product in the cart
     Then find the cart icon
    Examples:
     |Loginusername1    |Loginpassword1   |
     |lalitha           |password123      |
    
    
