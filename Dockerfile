# Multi-stage Dockerfile: build with Gradle wrapper and run the produced fat JAR

# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . /app

# Ensure gradlew has Unix line endings, is executable and run it with bash
RUN sed -i -e 's/\r$//' -e '1s/^\xEF\xBB\xBF//' gradlew && \
    chmod +x gradlew && \
    bash ./gradlew bootJar -x test --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 7777
ENV PORT=7777 SERVER_ADDRESS=0.0.0.0
# Optional: add curl for health checks if needed
RUN apt-get update && apt-get install -y --no-install-recommends curl && rm -rf /var/lib/apt/lists/*
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
  CMD curl -f http://localhost:7777/actuator/health || exit 1
CMD ["java", "-jar", "/app/app.jar"]

