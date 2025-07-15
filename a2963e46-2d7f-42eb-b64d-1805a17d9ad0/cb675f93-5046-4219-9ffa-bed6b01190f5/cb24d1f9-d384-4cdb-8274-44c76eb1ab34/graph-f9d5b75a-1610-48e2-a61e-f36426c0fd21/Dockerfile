# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21/target/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar

ADD target/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21/0.0.1-SNAPSHOT/graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "graph-f9d5b75a-1610-48e2-a61e-f36426c0fd21-0.0.1-SNAPSHOT.jar"]
