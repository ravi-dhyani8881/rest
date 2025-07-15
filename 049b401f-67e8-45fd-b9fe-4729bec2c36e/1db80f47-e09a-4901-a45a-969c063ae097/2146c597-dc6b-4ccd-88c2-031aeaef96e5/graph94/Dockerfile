# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/graph94-0.0.1-SNAPSHOT.jar graph94-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/graph94/target/graph94-0.0.1-SNAPSHOT.jar graph94-0.0.1-SNAPSHOT.jar

ADD target/graph94-0.0.1-SNAPSHOT.jar graph94-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/graph94/0.0.1-SNAPSHOT/graph94-0.0.1-SNAPSHOT.jar graph94-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "graph94-0.0.1-SNAPSHOT.jar"]
