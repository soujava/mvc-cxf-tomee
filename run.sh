#!/bin/sh

echo "

███████╗ ██████╗ ██╗   ██╗     ██╗ █████╗ ██╗   ██╗ █████╗ 
██╔════╝██╔═══██╗██║   ██║     ██║██╔══██╗██║   ██║██╔══██╗
███████╗██║   ██║██║   ██║     ██║███████║██║   ██║███████║
╚════██║██║   ██║██║   ██║██   ██║██╔══██║╚██╗ ██╔╝██╔══██║
███████║╚██████╔╝╚██████╔╝╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║
╚══════╝ ╚═════╝  ╚═════╝  ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝
                                                           
"

#export JAVA_HOME=$HOME/YOU_PATH_JDK_8
#export PATH=${JAVA_HOME}/bin:${PATH}
#export MAVEN_HOME=$HOME/YOU_PATH_MAVEN
#export PATH=${MAVEN_HOME}/bin:${PATH}

echo 'BUILD MAVEN' 

mvn clean install 

echo 'Running build of Docker-Compose'

docker-compose build 

echo 'Going up Docker-Compose'

docker-compose up -d

echo "loading..."

sleep 15 

echo "Start application in -> { http://localhost:8080/mvc-cxf } "

xdg-open http://localhost:8080/mvc-cxf

$SHELL