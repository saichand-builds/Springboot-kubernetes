# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder
COPY . .
RUN ./mvnw clean package

# Runtime stage  
FROM eclipse-temurin:17-jre-alpine
COPY --from=builder target/*.jar app.jar
USER 1000  # Non-root user for security
ENTRYPOINT ["java", "-jar", "/app.jar"]