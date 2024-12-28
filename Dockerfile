FROM openjdk:17-jdk-slim

WORKDIR /api-user-project/user-service-project

COPY target/api-user-project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
