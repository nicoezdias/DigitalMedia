# FROM openjdk:8-jdk-alpine
# RUN apk update && apk add bash
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# COPY wait-for-it.sh .
# ENTRYPOINT ["./wait-for-it.sh", "-t", "90","keycloak-service:8080", "--", "java", "-jar", "app.jar"]


FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean && mvn package 

FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk update && apk add bash
ARG JAR_FILE=eureka-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
COPY wait-for-it.sh .
ENTRYPOINT ["./wait-for-it.sh", "-t", "90","keycloak-service:8080", "--", "java", "-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]