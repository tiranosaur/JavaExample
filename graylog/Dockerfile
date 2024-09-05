FROM maven:3.8.1-openjdk-17

# Set the working directory
WORKDIR /server

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Build the application using Maven
RUN mvn clean package

# Expose the port
EXPOSE 8080
EXPOSE 12201

# Command to run the application
CMD ["java", "-jar", "target/spring-0.0.1-SNAPSHOT.jar"]
