FROM openjdk:18.0.2.1-slim

ARG JAR_FILE=/build/libs/module1.jar

COPY ${JAR_FILE} module1.jar

EXPOSE 8030

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=module1" , "/module1.jar"]
