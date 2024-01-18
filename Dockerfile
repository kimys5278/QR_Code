FROM openjdk:11-jdk

LABEL maintainer="kimys5278@gmail.com"

COPY target/ QRcode_Prac-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

