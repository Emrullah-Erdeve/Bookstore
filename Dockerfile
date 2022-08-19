FROM openjdk:18
EXPOSE 8080
ADD target/Bookstore-0.0.1-SNAPSHOT.jar Bookstore.jar
ENTRYPOINT ["java","-jar","/bookstoreapp.jar"]