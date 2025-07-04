FROM openjdk:11-jre-slim
Expose 8081
# ADD target/FebeTest-0.0.1-SNAPSHOT.jar FebeTest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/FebeTest/target/FebeTest-0.0.1-SNAPSHOT.jar FebeTest-0.0.1-SNAPSHOT.jar

ADD target/FebeTest-0.0.1-SNAPSHOT.jar FebeTest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/FebeTest/0.0.1-SNAPSHOT/FebeTest-0.0.1-SNAPSHOT.jar FebeTest-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "FebeTest-0.0.1-SNAPSHOT.jar"]
