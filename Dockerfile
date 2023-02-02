FROM openjdk:17-jdk-slim
MAINTAINER daiaurquilla
COPY target/DaiaUrquilla-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]
