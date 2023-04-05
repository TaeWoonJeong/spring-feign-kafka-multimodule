FROM openjdk:11-jre-slim

ARG JAR_FILE=/build/libs/module2-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} module2.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=module2" , "/module2.jar"]