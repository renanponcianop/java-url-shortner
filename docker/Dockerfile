FROM maven:3.8.4-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jdk
RUN addgroup --system spring
RUN adduser --system spring --ingroup spring
USER spring:spring
COPY --from=build /home/app/target/urlshortner-0.0.1-SNAPSHOT.jar app.jar
COPY docker/wait-for-it.sh /wait-for-it.sh
USER root
RUN chmod +x /wait-for-it.sh
RUN ls
ENTRYPOINT ["./wait-for-it.sh","mongo:27017","--","java","-jar","app.jar"]