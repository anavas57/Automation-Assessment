Feature: Automation Assessment
  Description: The user wants to verify that the list of devices returned from the server are displayed in the UI

Scenario: The user can retrieve the list of devices from the server app
Given the user wants to retrieve the list of devices from the server
When the user requests the list of devices from the server
Then the user gets the list of devices from the server

Scenario: The user can verify the list of devices returned by the server are displayed in the client app
Given the user has retrieved the list of devices from the server
When the user checks for the devices in the list in the client app
Then the user can verify the id of each device is displayed in the UI
And the user can verify the name of each device is displayed in the UI
And the user can verify the type of each device is displayed in the UI
And the user can verify the capacity of each device is displayed in the UI