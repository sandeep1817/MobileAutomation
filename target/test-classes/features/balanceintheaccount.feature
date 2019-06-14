Feature: Validate the balance in the account

	Scenario Outline: validate the account balance in savings account
		Given hdfc bank application is launched
		When username "<user>" and password "<password>" entered
		And user clicked on Account summary
		Then validate the balance in the account
	Examples:
	|user|password|
	|72578238||