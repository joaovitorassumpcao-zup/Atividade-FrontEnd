FROM openjdk:11-jre-slim
ENV APP_NAME escolaZup
COPY ./target/escolaZup.jar /app/escolaZup.jar
WORKDIR /app
CMD ["java", "-jar", "escolaZup.jar"]