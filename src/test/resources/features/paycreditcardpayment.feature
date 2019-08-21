Feature: Pay the credit card balance

	Scenario Outline: validate the account balance in savings account
		Given hdfc bank application is launched
		When username "<user>" and password "<password>" entered
		And user clicked on Account summary
		Then validate the balance in the account
		When amount in account is greater than credit bill
		And pay credit card bill total amount
		Then verify that payment is successful
	Examples:
	|user|password|
	|72578238||