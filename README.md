************************************************************
project wholeFood automation_sammple

Pre-Requisites
1. install java on your machine(java 8 preferred)
2. install maven
3. open this project in IDE like Intellij or eclipse.
4. download all dependencies by running mvn clean install in terminal

How to run the automation?
There are two ways to run automation
1. go to src->main->java->com->wholefoods->service-Runner.class. 
 right click ont test method and run as testNG
2. under project I have created runner.xml file. Right click on that and run as testNG.

Input and output.
Inputs:
- input.txt file is created under data provider packagesrc->main->java->com->wholefoods->dataProvider->input.txt
- all the urls for whoolfoods are defined there. each url will run as test case
- testNG feature:dataProvider is also defined under Runner.class where you can manually add url's under class.
Outputs:
- jackson api libraries are used to parse JasonObject to Json.
- writing the pretty Json to Output.txt file under src->main->java->com->wholefoods->output->Output.txt. 

html scrapper
- This projet is using selenium to extract text from html pages.
- String regex is used to find the attribute values and numbers.

Maven
use : mvn test command to run the project through maven.
Maven Libraries used
Selenium 3.141
testNG 6.10
Jackson core 2.10
jackson databind 2.10
maven surefire plugin for reports


Report:
if you want to find the testNG report.
go to target->surefire-reports-testng-report.html


 
