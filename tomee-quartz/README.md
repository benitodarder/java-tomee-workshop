# quartz-tomee

Simple clusterable Tomee 8.0.5 scheduled task.

* Includes sample GET http://localhost:8080/tomee-quartz-1.0/quartz
* Sample properties and tomee.xml file attached.
* Persistence using HSQLDB 2.6.0
* Corrected HSQLDB schema.
* JavaMelody configured at http://localhost:8080/tomee-hello-world-1.0/monitoring
* Sample Hsqldb command:  java -cp /c/Programs/hsqldb/2.4.1/hsqldb/lib/hsqldb.jar org.hsqldb.Server --database.0 Development/databases/tomee-quartz/tomee-quartz -dbname.0 quartz
