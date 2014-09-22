BillRive

BillRive is an Open Source Java based application meant to promote Community Learning.
This project can be used as a test bed to help fill the knowledge gaps of folks who are either new to Enterprise Web Development, have been working in the Software Engineering field but have some knowledge gaps, or those who are new to the scene and want to explore and learn using this project as a guide.

It could be that you want to learn about ORM paradigm (JPA/Hibernate) or Dependency Injection (Spring), or understand RESTful Web Services, or simply understand how a modern Web framework like Angular JS works.
This project helps you achieve those goals while working in a Community environment where the only goal is share what you learn with the others and learn what you can from others.

The members of this project meet once a week to discuss their  progress, challenges and what they would like to work on for the following week to continue their journey of learning.

BillRive comprises of two sub projects. 
The service is client agnostic and can serve any Web, Mobile and other applications. It is built around the principles of REST architecture using Spring Boot.

The client application is a modern Web Application which is designed using the MVC pattern, Dependency Injection 

billrive-service(Spring Boot, MVC, REST, JPA (Hibernate as provider), MySQL DB)
billrive-client (Angular JS, Bootstrap, Underscore)


Both the applications are currently bundled into one application titled "billrive-app"

Installation Instructions

What you Need:

-	Version Control: Git for Windows or Linux (git-scm.org) or Netbeans with GIT plugin installed
-	JDK 32/64-bit 
-   An IDE of your choice (Install Gradle support in your IDE)


To run,

- Clone this project using git (git clone https://github.com/billrive/billrive.git)
- Setup the MySQL Database. Execute conf/billrive.sql to populate the database tables
- Match your database username/password in BillriveJPA.java
- Run the app. From cmd/shell, type "gradlew bootRun". Make sure port 8080 is freed up before running this.


Architecture
BillRive-Service
-	Spring MVC (REST) architecture. REST architecture following the guidelines from this video (http://www.youtube.com/watch?v=5WXYw4J4QOU).

