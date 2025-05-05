# # Use Maven image to build the application
# FROM maven:3.8.5-openjdk-17 AS build

# # Set working directory inside the container
# WORKDIR /app

# # Copy your source code
# COPY . .

# # Build the application (skips tests for speed)
# RUN mvn clean package -DskipTests

# # Use lightweight JDK image to run the application
# FROM openjdk:17-jdk-slim

# # Set working directory for runtime
# WORKDIR /app

# # Copy the built JAR from the previous stage
# COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# # Command to run the application
# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

