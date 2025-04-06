FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar master.jar

ENTRYPOINT ["java", "-jar", "master.jar"]
