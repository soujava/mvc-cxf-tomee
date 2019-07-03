FROM openjdk:8u171-jdk-alpine 

COPY /target/mvc-cxf-exec.jar /opt/mvc-cxf-exec.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/mvc-cxf-exec.jar"]