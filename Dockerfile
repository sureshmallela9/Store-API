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
ENTRYPOINT ["java","-jar","/app/app.jar"]

