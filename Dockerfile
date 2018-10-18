FROM openjdk:10-jdk

VOLUME /tmp

# Make port 8081 available to the world outside this container
EXPOSE 8081

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# The application's jar file
ARG JAR_FILE=target/swagger-spring-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENV TIMEOUT=60 MYSQL_INSTANCE=mysql:3306
CMD ./wait-for-it.sh ${MYSQL_INSTANCE} -t ${TIMEOUT} && \
	java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]