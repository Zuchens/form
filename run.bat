set JAVA_HOME=%CD%\jdk1.8.0_171
set MAVEN_HOME=%DC%\mvn\apache-maven-3.6.0

call mvn clean install
call mvn jetty:run
