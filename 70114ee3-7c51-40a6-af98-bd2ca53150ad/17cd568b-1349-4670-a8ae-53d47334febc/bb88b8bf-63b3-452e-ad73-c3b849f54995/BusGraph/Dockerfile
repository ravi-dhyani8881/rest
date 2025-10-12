# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/BusGraph-0.0.1-SNAPSHOT.jar BusGraph-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/BusGraph/target/BusGraph-0.0.1-SNAPSHOT.jar BusGraph-0.0.1-SNAPSHOT.jar

ADD target/BusGraph-0.0.1-SNAPSHOT.jar BusGraph-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/BusGraph/0.0.1-SNAPSHOT/BusGraph-0.0.1-SNAPSHOT.jar BusGraph-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "BusGraph-0.0.1-SNAPSHOT.jar"]
