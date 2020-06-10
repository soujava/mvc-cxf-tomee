FROM adoptopenjdk/openjdk11-openj9:jre-11.0.7_10_openj9-0.20.0-alpine

COPY /target/mvc-cxf-exec.jar /opt/mvc-cxf-exec.jar

EXPOSE 8080
ENTRYPOINT java $JAVA_OPTS -jar /opt/mvc-cxf-exec.jar 
