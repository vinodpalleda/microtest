FROM tomcat:latest
COPY target/*.jar /usr/local/tomcat/webapps
WORKDIR /usr/local/tomcat/webapps/
EXPOSE 3001
ENTRYPOINT [ "java", "-jar", "/usr/local/tomcat/webapps/smsotpms-*-SNAPSHOT.jar"]
