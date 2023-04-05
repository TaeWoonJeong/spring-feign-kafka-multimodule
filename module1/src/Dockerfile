FROM openjdk:11-jre-slim

ARG JAR_FILE=/build/libs/module1-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} module1.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=module1" , "/module1.jar"]