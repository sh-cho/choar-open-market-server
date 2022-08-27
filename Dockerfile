FROM gradle:7.5.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon 


FROM eclipse-temurin:17-jre-jammy
RUN mkdir /app

ENV SPRING_PROFILE local

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILE}", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/spring-boot-application.jar"]

