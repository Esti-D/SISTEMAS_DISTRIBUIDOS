
# Etapa 1: construir el jar con Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
LABEL authors="estib"
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar la app con el jar generado
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]