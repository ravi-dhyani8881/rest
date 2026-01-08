# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/mcpservetr-0.0.1-SNAPSHOT.jar mcpservetr-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/mcpservetr/target/mcpservetr-0.0.1-SNAPSHOT.jar mcpservetr-0.0.1-SNAPSHOT.jar

ADD target/mcpservetr-0.0.1-SNAPSHOT.jar mcpservetr-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/mcpservetr/0.0.1-SNAPSHOT/mcpservetr-0.0.1-SNAPSHOT.jar mcpservetr-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mcpservetr-0.0.1-SNAPSHOT.jar"]
