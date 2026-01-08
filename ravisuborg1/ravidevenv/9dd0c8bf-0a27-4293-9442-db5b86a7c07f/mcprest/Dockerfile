# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/mcprest-0.0.1-SNAPSHOT.jar mcprest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/mcprest/target/mcprest-0.0.1-SNAPSHOT.jar mcprest-0.0.1-SNAPSHOT.jar

ADD target/mcprest-0.0.1-SNAPSHOT.jar mcprest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/mcprest/0.0.1-SNAPSHOT/mcprest-0.0.1-SNAPSHOT.jar mcprest-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mcprest-0.0.1-SNAPSHOT.jar"]
