# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/demo-openai-0.0.1-SNAPSHOT.jar demo-openai-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/demo-openai/target/demo-openai-0.0.1-SNAPSHOT.jar demo-openai-0.0.1-SNAPSHOT.jar

ADD target/demo-openai-0.0.1-SNAPSHOT.jar demo-openai-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/demo-openai/0.0.1-SNAPSHOT/demo-openai-0.0.1-SNAPSHOT.jar demo-openai-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-openai-0.0.1-SNAPSHOT.jar"]
