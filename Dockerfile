# FROM openjdk:17-jdk-slim
# VOLUME /tmp
# COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8081
# ENTRYPOINT ["java", "-jar", "/app.jar"]


FROM eclipse-temurin:17-jre

# Create a non-root user and group
RUN addgroup admin && adduser --ingroup admin louange

# Set the working directory for louange
WORKDIR /home/louange

# Copy the JAR file
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Change files ownership and permissions
RUN chown louange:admin app.jar

# Expose the application port
EXPOSE 8081

# Switch to louange user
USER louange

ENTRYPOINT ["java", "-jar", "app.jar"]
