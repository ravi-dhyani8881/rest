# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/FEBE7-0.0.1-SNAPSHOT.jar FEBE7-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/FEBE7/target/FEBE7-0.0.1-SNAPSHOT.jar FEBE7-0.0.1-SNAPSHOT.jar

ADD target/FEBE7-0.0.1-SNAPSHOT.jar FEBE7-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/FEBE7/0.0.1-SNAPSHOT/FEBE7-0.0.1-SNAPSHOT.jar FEBE7-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "FEBE7-0.0.1-SNAPSHOT.jar"]
