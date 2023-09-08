FROM openjdk:18.0.2.1-slim

ARG JAR_FILE=/build/libs/consumer.jar

COPY ${JAR_FILE} consumer.jar

EXPOSE 8020

ENTRYPOINT ["java","-jar","-Duser.timezone='Asia/Seoul'","-Dspring.profiles.active=consumer" , "/consumer.jar"]