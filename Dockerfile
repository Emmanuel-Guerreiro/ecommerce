FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml package

FROM openjdk:11-jre-slim

COPY --from=build /home/app/target/ecommerce.jar /app/ecommerce.jar
WORKDIR /app

EXPOSE 9000

CMD ["java","-jar", "ecommerce.jar"]