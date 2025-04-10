FROM openjdk:23-slim
LABEL authors="Vika"
LABEL version="1.0"
LABEL description="This is a docker image for my java project"
LABEL maintainer="Vika"
COPY . .
#COPY build/libs/T-Bank_JavaProject-0.0.1-SNAPSHOT.jar app.jar
#COPY src/main/java/ru/tbank /tmp
#WORKDIR /tmp
CMD ["java", "-jar", "app.jar"]