#FROM eclipse-temurin:17-jdk-alpine
#ADD target/rede-*.jar api.jar
#ENTRYPOINT ["java", "-jar", "/api.jar"]

FROM openjdk:17-alpine
WORKDIR /app
COPY /target/*.jar api.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "api.jar"]