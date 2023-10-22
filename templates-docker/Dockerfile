FROM openjdk:17-alpine
COPY "build/libs/${projectname}-${projectversion}.jar" "${projectname}.jar"
CMD ["java","-jar","${projectname}.jar"]
EXPOSE 8080