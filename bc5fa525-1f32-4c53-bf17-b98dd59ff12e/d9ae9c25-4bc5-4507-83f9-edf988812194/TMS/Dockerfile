# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/TMS-0.0.1-SNAPSHOT.jar TMS-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/TMS/target/TMS-0.0.1-SNAPSHOT.jar TMS-0.0.1-SNAPSHOT.jar

ADD target/TMS-0.0.1-SNAPSHOT.jar TMS-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/TMS/0.0.1-SNAPSHOT/TMS-0.0.1-SNAPSHOT.jar TMS-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "TMS-0.0.1-SNAPSHOT.jar"]
