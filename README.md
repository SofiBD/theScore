# theScore
------------
It is a Mobile Automation Challenge in an app to find a league, team or player and verify the specified steps

#Prerequsities - to be installed before running the code
------------------------
- Intellij -IDE
- Java JDK 11
- Appium 2
- Maven 3.6.3
- Android Studio Jellyfish - 2023.3.1
- Nodejs 
- Appium Inspector

  #Note
 ------
  The emulator used for execution had API UpsideDownCake with Level 34

#Technologies/tools used in building the framework
--------------------------------------------------
- Intellij -IDE
- Appium 2 - Mobile automation library
- Maven - Build automation tool
- Cucumber - BDD
- JDK 11 - Java JDK
- Extent Reports - Reporting framework
- GitHub - Version Control

 #Steps for executing the code
 ------------------------------
- Clone the repository
- The .apk file can be found in /src/test/resource/app folder
- Open the Android Studio and start a virtual device or connect a real device
- Set the device desired capabilities in config.properties file under /src/main/resources folder
- Execute the MyTestRunner file
- Extent Reports should be generated in both pdf and html format under /test-reports folder
- If a scenario fails, screenshot should be displayed in /test-reports/screenshots folder

 #Test Approach
 -----------------
 1. In the first scenario, user is at the start page. User selects his favourite league and team and lands on the
    Dashboard Page. User then verifies if the selected league and team are displayed on the Dashboard Page.
 2. In the second scenario, user is at the dashboard page. User searches for a player and a team, user validates
    its sub tabs and checks the functionality of back navigation. On clicking the back icon, user should 
    successfully navigate back to the Dashboard Page.


 #Test Report
 --------------
 A link to [test_results](test-reports%2023-May-24%2019-30-39/test-output/PdfReport/ExtentPdf.pdf)