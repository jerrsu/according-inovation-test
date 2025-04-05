FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar trip.jar

ENTRYPOINT ["java", "-jar", "trip.jar"]
