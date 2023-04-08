FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE=/build/libs/consumer-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} consumer.jar

EXPOSE 8020

ENTRYPOINT ["java","-jar","-Duser.timezone='Asia/Seoul'","-Dspring.profiles.active=consumer" , "/consumer.jar"]