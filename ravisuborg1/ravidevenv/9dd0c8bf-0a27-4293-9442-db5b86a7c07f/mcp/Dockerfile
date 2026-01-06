# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/mcp-0.0.1-SNAPSHOT.jar mcp-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/mcp/target/mcp-0.0.1-SNAPSHOT.jar mcp-0.0.1-SNAPSHOT.jar

ADD target/mcp-0.0.1-SNAPSHOT.jar mcp-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/mcp/0.0.1-SNAPSHOT/mcp-0.0.1-SNAPSHOT.jar mcp-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mcp-0.0.1-SNAPSHOT.jar"]
