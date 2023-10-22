FROM openjdk:17-alpine
COPY "build/libs/hello8-1.0.jar" "hello8.jar"
CMD ["java","-jar","hello8.jar"]
EXPOSE 8080