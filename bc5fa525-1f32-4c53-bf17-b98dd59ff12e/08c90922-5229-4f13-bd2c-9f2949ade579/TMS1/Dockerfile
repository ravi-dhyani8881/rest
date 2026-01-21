# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/TMS1-0.0.1-SNAPSHOT.jar TMS1-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/TMS1/target/TMS1-0.0.1-SNAPSHOT.jar TMS1-0.0.1-SNAPSHOT.jar

ADD target/TMS1-0.0.1-SNAPSHOT.jar TMS1-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/TMS1/0.0.1-SNAPSHOT/TMS1-0.0.1-SNAPSHOT.jar TMS1-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "TMS1-0.0.1-SNAPSHOT.jar"]
