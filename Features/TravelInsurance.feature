
Feature: Travel insurance 

  Scenario: Insurance plans for students 
  	Given User is on HomePage and clicks on Travel Insurance 
  	When User fills all the details 
  	And User clicks on student plans and fills details
  	Then Student plans should be displayed in low to high price