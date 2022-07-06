FROM tomcat:latest
COPY target/*.jar /usr/local/tomcat/webapps
EXPOSE 3001
ENTRYPOINT [ "java", "-jar", "/usr/local/tomcat/webapps/smsotpms-0.0.1-SNAPSHOT.jar"]
