FROM maven:3.6.0-jdk-11 as builder
WORKDIR /apps
COPY . .
RUN mvn clean install -DskipTests

FROM adoptopenjdk/openjdk11:latest
COPY --from=builder apps/target/*.jar testproject.jar
ENTRYPOINT ["java","-jar","/testproject.jar"]
