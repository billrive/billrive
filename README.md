BillRive
-------------------
billrive-service
billrive-client
-------------------


billrive-service
Spring RESTful WebService powered by MySQL using JPA with Hibernate as the provider.
To setup your Tomcat environment, replace your conf/server.xml and conf/context.xml with their equivalents in this repository (conf/tomcat folder). Use the conf/billrive.sql to populate your MySQL database. Match the connection details with that of those in conf/context.xml

Debugging in Tomcat:
Starting Tomcat in Debug mode from Netbeans doesn't work.
Do a "catalina jpda start" in the /bin folder externally and connect to port 8000 for debugging from Netbeans/Eclipse.

billrive-client
Currently a Angular JS Seeded project.



