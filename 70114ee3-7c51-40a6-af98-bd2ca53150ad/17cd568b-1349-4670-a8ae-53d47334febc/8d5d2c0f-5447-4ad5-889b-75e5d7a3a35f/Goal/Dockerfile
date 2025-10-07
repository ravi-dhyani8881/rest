# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/Goal-0.0.1-SNAPSHOT.jar Goal-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/Goal/target/Goal-0.0.1-SNAPSHOT.jar Goal-0.0.1-SNAPSHOT.jar

ADD target/Goal-0.0.1-SNAPSHOT.jar Goal-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/Goal/0.0.1-SNAPSHOT/Goal-0.0.1-SNAPSHOT.jar Goal-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Goal-0.0.1-SNAPSHOT.jar"]
