FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
