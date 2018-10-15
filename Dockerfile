FROM openjdk:10-jdk
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /inmueble

# Prepare by downloading dependencies
ADD pom.xml /inmueble/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /inmueble/src
RUN ["mvn", "package"]
EXPOSE 8081
ADD target/swagger-spring*.jar app.jar
CMD java -jar app.jar