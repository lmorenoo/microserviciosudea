FROM openjdk:10-jdk

VOLUME /tmp

RUN apt-get update -y && apt-get install maven -y

# Make port 8081 available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=target/swagger-spring-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]