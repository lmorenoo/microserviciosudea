FROM openjdk:10-jdk

COPY ./target/swagger-spring-1.0.0.jar /usr/src/inmueble/
WORKDIR /usr/src/inmueble
EXPOSE 8081
CMD ["java", "-jar", "swagger-spring-1.0.0.jar"]