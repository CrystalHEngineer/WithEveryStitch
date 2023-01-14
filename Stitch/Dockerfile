FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN --mount=type=secret,id=application_properties,dst=/etc/secrets/application.properties cp /etc/secrets/application.properties /home/app/src/main/resources
RUN mvn -f /home/app/pom.xml clean package 

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/Stitch-0.0.1-SNAPSHOT.war /app.war
COPY --from=build /home/app/src/ /src/
EXPOSE 8080
ENTRYPOINT java -jar /app.war 