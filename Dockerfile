FROM openjdk:17-jdk-alpine

RUN ls -l ./target
COPY ./target/ems-backend.jar ems-backend.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/ems-backend.jar"]