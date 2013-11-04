BillRive
-------------------
billrive-service
billrive-client
-------------------

Billrive Development Setup Guide
Introduction:
Billrive is comprised of two applications (for now)
billrive-service (Spring MVC, REST, JPA (Hibernate as provider), MySQL DB)
billrive-client (Angular JS, Bootstrap, Underscore)

Initial Setup:
•	Recommended Tools for development: (The project is IDE neutral but this setup is tested and works best)
o	Netbeans, MySQL Community Cluster, MySQL Workbench, JBOSS 6/7, Netbeans Chrome plugin,  Chrome Angular Batarang plugin. (Recent versions unless specified otherwise)
•	Clone the repository to your computer. 
o	git clone http://github.com/billrive/billrive.git

Setting up billrive-client:
•	The billrive-client project is a Netbeans HTML5 project. So Netbeans identified the project and you can open it in Netbeans that way (File -> Open -> point to the downloaded billrive-client folder).
•	Make sure that you have Netbeans Chrome plugin installed. Restart both Chrome and Netbeans.
•	Now expand the billrive-client project -> app . Right click and hit "run". It should open it and show the client view in Chrome. If it doesn't, Right click on the project -> properties -> Run. In "Browser" drop down, select "Netbeans with Chrome Integration"
•	Now retry running the index.html in the app folder.
•	This setup enables setting up breakpoints for debugging javascript (Angular).
Setting up Application Server and the Database:
•	The conf folder from the repository has all the configuration files needed for this project.
•	Tomcat: 
To setup your Tomcat environment, replace your conf/server.xml and conf/context.xml with their equivalents in this repository (conf/tomcat folder). Use the conf/billrive.sql to populate your MySQL database. Match the connection details with that of those in conf/context.xml

Debugging in Tomcat:
Starting Tomcat in Debug mode from Netbeans doesn't work.
Do a "catalina jpda start" in the /bin folder externally and connect to port 8000 for debugging from Netbeans/Eclipse.
From Netbeans: Go to server properties and setup the right debugging option and the port number. Use the same port number to debug.

Permgen Error:
Add the following VM options to resolve the error (can be added as startup env args in Netbeans)
-Xms256m -Xmx512m -XX:MaxPermSize=512m -XX:PermSize=128m



•	Download mysql jdbc driver jar and paste it in the lib folder.
•	MySQL: Download MySQL. Start the server. Download MySQL Workbench. Open up MySql Workbench and create a connection to your localhost MySQL instance. Create a database titled 'billrivedb'.
•	Use the conf/billrive.sql to populate the database.


Setting up billrive-service:
•	billrive-service is a maven project. You can open the project in Netbeans or import it into Eclipse.
•	Install Maven, JDK 6/7 on your computer and run mvn install or package and deploy the application to the application server. The following REST url should output some sample JSON for the  bills object.
o	http://localhost:8080/billrive-service/rest/1/bills/


Architecture
BillRive-Service
•	Spring MVC (REST) architecture. REST architecture following the guidelines from this video (http://www.youtube.com/watch?v=5WXYw4J4QOU).




billrive-service
Spring RESTful WebService powered by MySQL using JPA with Hibernate as the provider.
To setup your Tomcat environment, replace your conf/server.xml and conf/context.xml with their equivalents in this repository (conf/tomcat folder). Use the conf/billrive.sql to populate your MySQL database. Match the connection details with that of those in conf/context.xml

Debugging in Tomcat:
Starting Tomcat in Debug mode from Netbeans doesn't work.
Do a "catalina jpda start" in the /bin folder externally and connect to port 8000 for debugging from Netbeans/Eclipse.
From Netbeans: Go to server properties and setup the right debugging option and the port number. Use the same port number to debug.

Permgen Error:
Add the following VM options to resolve the error (can be added as startup env args in Netbeans)
-Xms256m -Xmx512m -XX:MaxPermSize=512m -XX:PermSize=128m

JRebel:
-Xms256m -Xmx512m -XX:MaxPermSize=512m -XX:PermSize=128m -javaagent:c:/dev/jrebel/jrebel.jar -Drebel.remoting_plugin=true

billrive-client
Currently a Angular JS Seeded project.



