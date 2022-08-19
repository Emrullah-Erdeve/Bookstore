FROM openjdk:18
EXPOSE 8080
ADD target/Bookstore.jar Bookstore.jar
ENTRYPOINT ["java","-jar","/bookstoreapp.jar"]