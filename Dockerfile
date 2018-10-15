FROM openjdk:10-jdk
ADD target/swagger-spring*.jar app.jar
CMD java -jar app.jar