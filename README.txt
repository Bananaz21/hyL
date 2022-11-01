My first forray into a major Java project! 
Not paticularly clean nor a good example of good code, but with the school software restrictions many workarounds had to be used. The json library jar just sitting there is a great example of one. I made do with what I had in this project, and while I had many, many pains with the school restrictions I had lots of fun with this project! 

The project is a Hypixel API viewer, a revision to the first coding project I ever made. Instead of a CLI interface, it has a GUI complete with stats of multiple games including Bedwars, Skywars, and Skyblock. It also has an included Bazzar Stocks Api viewer. :D

To run this project you need to import the json library in the repository. Due to software restrictions, Gradle or Maven were not available for this project. Trust me, i've tried.
Assuming you are using eclipse,

1. Right-click on json-20220320.jar > Build Path > Config Build Path
	Check json-20220320.jar
	Apply and Close

2. To run main, click on "No Launch Config" > "New Launch Config"
	Launch Mode: Run
	Launch Config Type: Java Application
	Click Next
	Main Class: client

From there, you should be able to run using the run button.
