# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk-alpine AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build output (JAR file) into the container
COPY target/doctor-scheduling-service-0.0.1-SNAPSHOT.war app.war

# Expose the port your application runs on
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.war"]