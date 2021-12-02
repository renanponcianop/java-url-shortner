FROM openjdk:11-jdk
RUN addgroup --system spring
RUN adduser --system spring --ingroup spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY docker/wait-for-it.sh /wait-for-it.sh
USER root
RUN chmod +x /wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh","mongo:27017","--","java","-jar","app.jar"]
