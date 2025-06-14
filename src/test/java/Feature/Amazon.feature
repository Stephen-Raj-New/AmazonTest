@Amazon
Feature: Verify that a user can access Amazon with guest Account.

Background: 
					Given Launch the Browser and Open the Amazon Website
					When Verify the user on the Webpage

@Open					
Scenario: Open the Amazon Website
					
					Then CLose the Browser

@Search					
Scenario: Search for Mobiles

					Then Search Phone on Search box
					And Click on Search
					And Click on Nokia phone
					#Then Verify the Page was loaded
					And Close the Browser