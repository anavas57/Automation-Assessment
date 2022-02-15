# Automation Assessment
This project includes a java class E2EAssessment running the following test cases:
   Make an API call to retrieve the list of devices.
   Use the list of devices to check the elements are visible in the DOM.
From those two scenarios, a demo framework was created. Same framework can be implemented in other tecnologies, like C# or Nodejs.

Example reports can be found in the directory: .\target\cucumber-html-report

# Installation
When attempting to import this project make sure you are using JAVA 8

Import this project into your choice of IDE as a Maven project. This is required for it to grab its required dependencies.

This should pull in the dependencies but if this does not work for any reason, you can use maven command line to install them.
mvn clean install
This does require you to have maven installed on your file path though. A way around this is to use IntelliJ which comes bundled with maven. You will only require the free Community version.

# Usage
Before running this automation, make sure to launch the server and client applications in Nodejs command prompts/
To validate the everything is installed correctly, please run TestRunner or the E2EAssessment classes.
