Feature: To test the swipe functionality in Instagram

	Scenario: Validate that swipe functionality is working fine
		Given instagram application is launched
		When swipe action is performed
		Then verify that messages tab is opened