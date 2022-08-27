FROM openjdk:11 as build
USER root
COPY target/eva-0.0.1-SNAPSHOT.jar eva-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/eva-0.0.1-SNAPSHOT.jar"]