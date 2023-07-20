FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/app.jar .

ENV SPRING_PROFILES_ACTIVE=dev

EXPOSE 8080

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]