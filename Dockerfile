FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package javadoc:javadoc -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/SecureApplication-0.0.1-SNAPSHOT.jar demo.jar
#COPY --from=build /target/site/apidocs/index.html index.html
#EXPOSE 8080
EXPOSE 7777
EXPOSE 63342
ENTRYPOINT ["java","-jar","demo.jar"]