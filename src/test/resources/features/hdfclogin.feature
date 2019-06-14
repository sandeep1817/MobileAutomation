Feature: To login into the HDFC application

	Scenario Outline: To validate that login functionality of HDFC bank is working fine
		Given hdfc bank application is launched
		When username "<user>" and password "<password>" entered
		Then home page of the application should display
	Examples: 
		|user|password|
		|72578238||