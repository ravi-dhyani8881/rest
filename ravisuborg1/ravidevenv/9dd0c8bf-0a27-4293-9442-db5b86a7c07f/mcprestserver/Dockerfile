# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/mcprestserver-0.0.1-SNAPSHOT.jar mcprestserver-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/mcprestserver/target/mcprestserver-0.0.1-SNAPSHOT.jar mcprestserver-0.0.1-SNAPSHOT.jar

ADD target/mcprestserver-0.0.1-SNAPSHOT.jar mcprestserver-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/mcprestserver/0.0.1-SNAPSHOT/mcprestserver-0.0.1-SNAPSHOT.jar mcprestserver-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mcprestserver-0.0.1-SNAPSHOT.jar"]
