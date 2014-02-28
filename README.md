BillRive

BillRive is an Open Source Bill sharing application meant to promote Community Learning.
This project aims to help fill the knowledge gaps of folks who are either new to Enterprise Web
Development, have been working in the Software Engineering field but have some knowledge gaps, or those
who are new to the scene and want to explore and learn using this project as a guide.

It could be that you want to learn about ORM paradigm (JPA/Hibernate) or Dependency Injection (Spring),
or understand RESTful Web Services, or simply understand how a modern Web framework like Angular JS works.
This project helps you achieve those goals while working in a Community environment where the only goal is
share what you learn with the others and learn what you can from others.

The members of this project meet once a week to discuss their  progress, challenges and what they
would like to work on for the following week to continue their journey of learning.

BillRive comprises of two sub projects. 
The service is client agnostic and can serve any Web, Mobile
and other applications. It is built around the principles of REST architecture.
The client application is a modern Web Application which is designed using the MVC pattern, 
Dependency Injection (You heard it right!)
-------------------
billrive-service 
billrive-client
-------------------

Installation Instructions

Basically, you will need to do the following

-Setup the Application Server (No longer needed. Billrive works out of the box on any Java Web Application Server)
-Setup the Database
-Setup your Development Environment

What you Need:
-Version Control: Git for Windows or Linux (git-scm.org) or Netbeans with GIT plugin installed
-IDE: Netbeans or Eclipse 
-Application Server: Tomcat 7
-Debugging: Netbeans chrome integration plugin (optional but preferred if you'd like to use Netbeans)
-Debugging: Angular Batarang plugin for Chrome (optional)

To get a copy of the source code, Clone the GIT repository using Netbeans GIT plugin or through the native windows GIT plugin.

git clone https://github.com/billrive/billrive.git

Billrive Development Setup Guide
Introduction:
Billrive is comprised of two applications (for now)
billrive-service (Spring MVC, REST, JPA (Hibernate as provider), MySQL DB)
billrive-client (Angular JS, Bootstrap, Underscore)

Initial Setup:
-	Recommended Tools for development: (The project is IDE neutral but this setup is tested and works best)
-	Netbeans, MySQL Community Cluster, MySQL Workbench, JBOSS 6/7, Netbeans Chrome plugin,  Chrome Angular Batarang plugin. (Recent versions unless specified otherwise)
-	Clone the repository to your computer. 
-	git clone http://github.com/billrive/billrive.git

Setting up billrive-client:
-	The billrive-client project is a Netbeans HTML5 project. So Netbeans identifies the project and you can open it in Netbeans that way (File -> Open -> point to the downloaded billrive-client folder).
-	Make sure that you have Netbeans Chrome plugin installed. Restart both Chrome and Netbeans.
-	Now expand the billrive-client project -> app . Right click and hit "run". It should open it and show the client view in Chrome. If it doesn't, Right click on the project -> properties -> Run. In "Browser" drop down, select "Netbeans with Chrome Integration"
-	Now retry running the index.html in the app folder.
-	This setup enables setting up breakpoints for debugging javascript (Angular).
Setting up Application Server and the Database:
-	The conf folder from the repository has all the configuration files needed for this project.

Debugging in Tomcat:
Starting Tomcat in Debug mode from Netbeans doesn't work.
Do a "catalina jpda start" in the /bin folder externally and connect to port 8000 for debugging from Netbeans/Eclipse.
From Netbeans: Go to server properties and setup the right debugging option and the port number. Use the same port number to debug.

Permgen Error:
Add the following VM options to resolve the error (can be added as startup env args in Netbeans)
-Xms256m -Xmx512m -XX:MaxPermSize=512m -XX:PermSize=128m

-	Download mysql jdbc driver jar and paste it in the lib folder.
-	MySQL: Download MySQL. Start the server. Download MySQL Workbench. Open up MySql Workbench and create a connection to your localhost MySQL instance. Create a database titled 'billrivedb'.
-	Use the conf/billrive.sql to populate the database.


Setting up billrive-service:
-	billrive-service is a maven project. You can open the project in Netbeans or import it into Eclipse.
-	Install Maven, JDK 6/7 on your computer and run mvn install or package and deploy the application to the application server. The following REST url should output some sample JSON for the  bills object.
o	http://localhost:8080/billrive-service/rest/1/bills/


Architecture
BillRive-Service
-	Spring MVC (REST) architecture. REST architecture following the guidelines from this video (http://www.youtube.com/watch?v=5WXYw4J4QOU).

