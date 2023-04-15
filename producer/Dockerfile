FROM openjdk:18.0.2.1-slim

ARG JAR_FILE=/build/libs/producer-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} producer.jar

EXPOSE 8010

ENTRYPOINT ["java","-jar","-Duser.timezone='Asia/Seoul'","-Dspring.profiles.active=producer" , "/producer.jar"]