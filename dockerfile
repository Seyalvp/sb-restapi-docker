FROM openjdk:8
COPY ./target/firstrestapi-1.0-SNAPSHOT.jar /app/firstrestapi.jar
CMD ["java","-jar","/app/firstrestapi.jar"]