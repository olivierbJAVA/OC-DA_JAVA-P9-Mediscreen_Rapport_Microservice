# Mediscreen - Rapport Microservice
Welcome to Mediscreen !

- Mediscreen is a medical company specialized in diseases diagnosis
- Mediscreen wants to develop a new application which goal is to diagnose the risk for patients to develop diabetes

### Mediscreen Diabetes Application

The application is composed of 3 Microservices :
- Mediscreen Patient : in charge of managing patients and their personal data
- Mediscreen Note : in charge of managing notes written by doctors
- Mediscreen Rapport : in charge of generating reports evaluating the risk for patients to develop diabetes

This repository contains the Mediscreen Rapport Microservice.

You will find the other Microservices in the following repositories :
- Mediscreen Patient : <https://github.com/ob78/Mediscreen_Patient_Microservice/tree/develop>
- Mediscreen Note : <https://github.com/ob78/Mediscreen_Note_Microservice/tree/develop>

### Technologies used

Technologies used for this Microservice are the following.

BackEnd side :
- Java as programming language
- SpringBoot for the web application which is based on the MVC pattern
- Server is SpringBoot Tomcat embedded
- Gradle to run the tests, build and package the application
- JUnit as tests engine
- Mockito as mocking framework for tests

Microservices communicate using REST APIs and Feign HTTP client.

### Getting Started

The following instructions will get you a copy of the project up and running on your local machine.

You need to install the following software :

- Java 8
- Gradle 6.6.1
- Docker + Docker-Compose
>You don't need to install SpringBoot by yourself because dependencies will be added by Gradle

### Installing

You will find below a step by step explanation that tell you how to get a development environment running :

1.Install Java :
<https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html>

2.Install Gradle :
<https://gradle.org/install/>

3.Install Docker + Docker-Compose :
<https://docs.docker.com/get-docker/>

>Please note that the application has been developed with the IntelliJ IDE.

### Profiles and Configuration

Three Spring profiles are available for each following phase :

- PROD profile used for Production phase
- DEV profile used for Development phase
- TEST profile used for Test phase

There is a global Spring configuration properties file : application.properties, and a dedicated configuration properties file for each profile : application-*profileName*.properties. 
These files are stored in the src/main/resources directory for PROD and DEV profiles and in the src/test/resources directory for the TEST profile.

The URL (hostname + port) for the Patient and Note Microservices communication can be configured in these files.

The terms that are used to generate the diabetes risk report and that are searched in the patient notes history can be parametrized in the configuration file called *declencheurs*.

### Microservice running

You can run the Microservice in an IDE or in Docker containers :
- To run the Microservice in an IDE, you must use the DEV profile.  
- To run the Microservice in Docker containers, you must use the PROD profile.  

### Endpoints

For information about EndPoints that are exposed by the Mediscreen Rapport Microservice, please refer to the document located in this repository called : *Specifications_API-REST_Sprint3-RAPPORT*

### Docker container deployment

A Dockerfile is present in this repository in order to deploy the application in a Docker container.
>In order to build a Docker Image using this Dockerfile, please use the following command line (in the *Dockerfile* directory) :
`docker build -t rapport .`

When the Rapport Docker image is created, as well as the Patient and Note Docker images, you can run the whole application (i.e. the 3 Microservice) using the *docker-compose.yml* file located in this repository.
>To do this, please use the following command line (in the *docker-compose.yml* directory) :
`docker-compose up`
 
### Tests

Tests are included. You can run them using JUnit runner or using Gradle.

### Manual tests in command line using Curl

If you want to manually test the application, you will find below Curl command lines in order to :
- Create a patient
- Add its notes
- Generate the diabetes risk assessment report

For each level of diabetes risk assessment : 
- None
- Borderline
- InDanger
- EarlyOnset

1.Test None :  
`curl -d "family=TestNone&given=Test&dob=1966-12-31&sex=F&address=1 Brookside St&phone=100-222-3333" -X POST http://localhost:8081/patients/add`  

`curl -d "lastName=TestNone&firstName=Test&note=Patient states that they are 'feeling terrific' Weight at or below recommended level" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl "http://localhost:8080/assess/lastNameAndFirstName?lastName=TestNone&firstName=Test"`  

2.Test Borderline :  
`curl -d "family=TestBorderline&given=Test&dob=1945-06-24&sex=M&address=2 High St&phone=200-333-4444" -X POST http://localhost:8081/patients/add`  

`curl -d "lastName=TestBorderline&firstName=Test&note=Patient states that they are feeling a great deal of stress at work Patient also complains that their hearing seems Abnormal as of late" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl -d "lastName=TestBorderline&firstName=Test&note=Patient states that they have had a Reaction to medication within last 3 months Patient also complains that their hearing continues to be problematic" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl "http://localhost:8080/assess/lastNameAndFirstName?lastName=TestBorderline&firstName=Test"`  

3.Test InDanger :  
`curl -d "family=TestInDanger&given=Test&dob=2004-06-18&sex=M&address=3 Club Road&phone=300-444-5555" -X POST http://localhost:8081/patients/add`  

`curl -d "lastName=TestInDanger&firstName=Test&note=Patient states that they are short term Smoker" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl -d "lastName=TestInDanger&firstName=Test&note=Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl "http://localhost:8080/assess/lastNameAndFirstName?lastName=TestInDanger&firstName=Test"`  

4.Test EarlyOnset :  
`curl -d "family=TestEarlyOnset&given=Test&dob=2002-06-28&sex=F&address=4 Valley Dr&phone=400-555-6666" -X POST http://localhost:8081/patients/add`  

`curl -d "lastName=TestEarlyOnset&firstName=Test&note=Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl -d "lastName=TestEarlyOnset&firstName=Test&note=Patient states that they are experiencing back pain when seated for a long time" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl -d "lastName=TestEarlyOnset&firstName=Test&note=Patient states that they are a short term Smoker Hemoglobin A1C above recommended level" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl -d "lastName=TestEarlyOnset&firstName=Test&note=Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction" -X POST http://localhost:8082/patHistory/addByLastNameAndFirstName`  

`curl "http://localhost:8080/assess/lastNameAndFirstName?lastName=TestEarlyOnset&firstName=Test"`  
