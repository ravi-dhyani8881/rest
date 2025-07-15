# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47/target/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar

ADD target/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47/0.0.1-SNAPSHOT/graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "graph-1d17b803-4b18-48a3-b0f7-ed6e46eb9b47-0.0.1-SNAPSHOT.jar"]
