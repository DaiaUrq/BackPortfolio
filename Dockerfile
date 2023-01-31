FROM amazoncorretto:17-alpine
MAINTAINER DaiaUrquilla
COPY target/DaiaUrquilla-0.0.1-SNAPSHOT.jar  DUP-app.jar
ENTRYPOINT ["java","-jar", "/DUP-app.jar"]
