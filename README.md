## JAVA SELENIUM FRAMEWORK

## REQUIREMENTS TO TEST PIPELINE LOCALLY

Having installed:
- [Docker](https://www.docker.com/get-started/) (#test-pipeline-locally)
- [Act](https://github.com/nektos/act) optional, only if you want to validate [TEST PIPELINE LOCALLY](#test-pipeline-locally) for more info [here](https://nektosact.com/usage/index.html)

## INSTALL JDK

- Install JDK, if you are on mac:

```bash
# Check if Java is installed
java -version
# Install OpenJDK
brew install openjdk
# Update Maven
brew update
# Install Maven
brew install maven
```

## STEPS TO START SELENIUM JAVA PROJECT INTELIJ IDEA

- open intellij idea
- click on `New Project`
- choose `Java`
- in the right options choose `Maven`
- set the location project
- set JDK 22
- fill in the following information:
    - Group Id: `com.selenium.test`
    - Artifact Id: `my-first-test`
- click on "Next"
- choose the location to create the project
- click on "Finish"

```
selenium
│
├── pom.xml
├── testng.xml
├── README.md
│
├── src
│
│   ├── main
│   │
│   │   ├── java
│   │   │
│   │   │   └── com
│   │   │       └── peter
│   │   │
│   │   └── resources
│   │       ├── config.properties
│   │       └── log4j2.xml
│   │
│   └── test
│       │
│       ├── java
│       │
│         └── com
│             └── peter
│                 │
│                 ├── base
│                 │      BaseTest.java
│                 │      BasePage.java
│                 │
│                 ├── driver
│                 │      DriverFactory.java
│                 │
│                 ├── pages
│                 │      LoginPage.java
│                 │      InventoryPage.java
│                 │      CartPage.java
│                 │      CheckoutPage.java
│                 │
│                 ├── tests
│                 │      LoginTest.java
│                 │      InventoryTest.java
│                 │      CheckoutTest.java
│                 │
│                 ├── utils
│                 │      ConfigReader.java
│                 │      WaitUtils.java
│                 │      ScreenshotUtils.java
│                 │
│                 ├── listeners
│                 │      TestListener.java
│                 │
│                 └── constants
│                      FrameworkConstants.java
│
│
└── target
```

## STEPS TO START SELENIUM JAVA PROJECT VS CODE

- open the vs code command palette: command + shift + p
- type "Java: Create Java Project"
- choose `Maven` option
- select `maven-archetype-quickstart`
- choose `latest` version
- define the Group Id, example `com.selenium.test`
- define the Artifact Id, example `my-first-test`
- choose the location to create the project
- wait for vs code setup the project, this process can be review in the terminal
- Press ENTER to set de default snapthot value or set a value and press ENTER
- type Y to confirm the project creation

## SETUP MAVEN

- open the pom.xml fiel and find the `<dependencies>` tag.
- then add the following dependency inside the `<dependencies>` tag:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.45.0</version> <!-- Puedes verificar la versión más reciente en mvnrepository.com -->
    <scope>compile</scope>
</dependency>
```

## FIRST STEPS TO AUTOMATE

- open the terminal
- go to the proyect folder created by vs code (wher is pom.xml file) this is the root of project
- type `mvn clean compile`


## RUNNING THE TESTS

```shell
# Run all tests
mvn test
# Run tests based on testng.xml file
mvn test -DsuiteXmlFile=testng.xml
```

## TEST PIPELINE LOCALLY

```shell
brew install act # install for testing pipeline locally
# if you have an issue executing a workflow add push event
act -l                                        # list all available workflows
act -j test -s ACT=true                       # run test job
act -W .github/workflows/WORKFLOW_NAME.yml    # run a specific workflow
```
