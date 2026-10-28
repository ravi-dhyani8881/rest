# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/FullSync-0.0.1-SNAPSHOT.jar FullSync-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/FullSync/target/FullSync-0.0.1-SNAPSHOT.jar FullSync-0.0.1-SNAPSHOT.jar

ADD target/FullSync-0.0.1-SNAPSHOT.jar FullSync-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/FullSync/0.0.1-SNAPSHOT/FullSync-0.0.1-SNAPSHOT.jar FullSync-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "FullSync-0.0.1-SNAPSHOT.jar"]
