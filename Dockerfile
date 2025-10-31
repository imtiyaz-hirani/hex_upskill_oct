# Stage 1: Use a lightweight JRE base image for the final container
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot fat JAR from your local machine to the container
COPY target/hex-trs-0.0.1-SNAPSHOT.jar /app/hex-trs-0.0.1-SNAPSHOT.jar

# Declare the port your Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "hex-trs-0.0.1-SNAPSHOT.jar"]