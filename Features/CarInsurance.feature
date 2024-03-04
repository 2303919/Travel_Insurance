
Feature: Car Insurance 

  
  Scenario: Invalid details in car Insurance 
    Given User is on HomePage and clicks on Car Insurance 
    When Fills all the car details
    And Gives invalid number or email 
    Then Invalid email or number message should be displayed
    #Then Enter all valid details and get car insurance quote 
    
