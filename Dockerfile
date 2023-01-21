FROM openjdk:8-jdk-alpine
 
WORKDIR /usr/src/app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sed -i 's/\r$//' mvnw
#RUN /bin/sh ./mvnw dependency:go-offline
 
COPY src ./src
COPY src/main/resources/application.properties  ./src/main/resources/application.properties

CMD ["./mvnw", "spring-boot:run"]