FROM openjdk:11 as build
USER root
COPY target/spring-0.0.1-SNAPSHOT.jar spring-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-0.0.1-SNAPSHOT.jar"]