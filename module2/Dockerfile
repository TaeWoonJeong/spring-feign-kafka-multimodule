FROM openjdk:18.0.2.1-slim

ARG JAR_FILE=/build/libs/module2.jar

COPY ${JAR_FILE} module2.jar

EXPOSE 8040

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=module2" , "/module2.jar"]
