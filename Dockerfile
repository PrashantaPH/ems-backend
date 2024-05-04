FROM openjdk:17-jdk-alpine

COPY target/SpringbootApplicatipon-0.0.1-SNAPSHOT.jar ems-backend.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/ems-backend.jar.jar"]