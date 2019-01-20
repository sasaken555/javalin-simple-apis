FROM openjdk:8-jdk-alpine as build
COPY . /usr
WORKDIR /usr
RUN ./gradlew build

FROM openjdk:8-jre-alpine
COPY --from=build /usr/build/libs/javalin-qs-1.0.0-SNAPSHOT.jar /app/
EXPOSE 7000
CMD java -jar /app/javalin-qs-1.0.0-SNAPSHOT.jar
