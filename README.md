LRS Connect Automation
===========
Steps to run using Maven command.
1. Navigate to LRSConnectAutomation project.
2. Run below mention maven command. Smoke test suite automatically started and result will be displayed soon on console.
	Ex. mvn clean install -Denv="dev" -Dbrowser="chrome"
	Note: Use dev, test and prod for env variable and chrome and phantom for browser variable. If only 'mvn clean install' is used 	by default. env is set as dev and browser is set as phantomjs.
