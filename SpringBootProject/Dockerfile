# Stage 1: Build Spring Boot application
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Give permission to Maven wrapper
RUN chmod +x mvnw
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy generated JAR file
COPY --from=build /app/target/*.jar app.jar

EXPOSE 2000

ENTRYPOINT ["java", "-jar", "app.jar"]
