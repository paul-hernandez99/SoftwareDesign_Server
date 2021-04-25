# SoftwareDesign_Server
It is the server part of the application corresponding to the Software Design's project. The application might go along with the several design patterns we have seen in class.

## MAVEN COMMANDS
* **mvn validate**: Validate the project is correct and all necessary information is available
* **mvn clean**: Removes any file created out of mvn execution
* **mvn compile**: Compiles and enhances the java classes. Note that class enhancing is done inside the compiling phase as it is specified in the pom.xml (build -> plugin -> execution -> enhance). You can read more about this magic [Here](http://www.datanucleus.org/products/accessplatform_4_1/jpa/enhancer.html) "... technique of byte-code manipulation to make your normal Java classes "persistable ..."
* **mvn datanucleus:schema-create**: Automatically forward-engineer our classes to the database, taking into account the mapping meta-annotations
* **mvn datanucleus:schema-delete**: Delete the database schema created in create-db-schema
