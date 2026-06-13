#Builder
FROM gradle:8.5-jdk21 AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY .git .git
COPY src src

RUN ./gradlew bootJar --no-daemon

#Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 6000

ENTRYPOINT ["java", "-jar", "app.jar"]