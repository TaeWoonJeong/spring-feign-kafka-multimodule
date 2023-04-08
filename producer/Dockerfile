FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE=/build/libs/producer-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} producer.jar

EXPOSE 9070


ENTRYPOINT ["java","-jar","-Duser.timezone='Asia/Seoul'","-Dspring.profiles.active=producer" , "/producer.jar"]