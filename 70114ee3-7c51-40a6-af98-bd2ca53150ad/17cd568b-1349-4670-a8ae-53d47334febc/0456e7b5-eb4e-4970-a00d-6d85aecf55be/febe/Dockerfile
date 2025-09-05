# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/febe-0.0.1-SNAPSHOT.jar febe-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/febe/target/febe-0.0.1-SNAPSHOT.jar febe-0.0.1-SNAPSHOT.jar

ADD target/febe-0.0.1-SNAPSHOT.jar febe-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/febe/0.0.1-SNAPSHOT/febe-0.0.1-SNAPSHOT.jar febe-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "febe-0.0.1-SNAPSHOT.jar"]
