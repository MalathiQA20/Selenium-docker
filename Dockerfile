FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
#Workspace
WORKDIR /usr/share/dockerimage
#Add .jar under target from host into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
#if you have test data files .csv/json/.xls,add them as well
#Add suite files
ADD book-flight-module.xml book-flight-module.xml
ADD searchmodule.xml searchmodule.xml
#Add healthcheck script
ADD healthcheck.sh  healthcheck.sh
#Enviroment variables
#BROWSER
#MODULE
#HUB_HOST
ENTRYPOINT sh healthcheck.sh