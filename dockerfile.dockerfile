# Étape de build
FROM maven:3.8.6-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package

# Étape d'exécution
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]