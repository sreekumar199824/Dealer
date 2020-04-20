FROM openjdk:8-jdk-alpine
COPY target/dealer-0.0.1-SNAPSHOT.jar dealer.jar
ENTRYPOINT ["java","-jar","dealer.jar"]