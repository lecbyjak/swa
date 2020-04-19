FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S oxus && adduser -S oxus -G oxus
USER oxus:oxus
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]