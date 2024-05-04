FROM openjdk:17-jdk-alpine

COPY /absolute/path/to/target/ems-backend.jar ems-backend.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/ems-backend.jar"]