FROM eclipse-temurin:17-jdk-alpine
COPY target/ProjectCafePizza-0.0.1-SNAPSHOT.jar cafepizzah2.jar
COPY src/main/resources/templates/ /app/src/main/resources/templates/
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/cafepizzah2.jar"]