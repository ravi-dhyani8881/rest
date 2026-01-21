# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/HRMS-0.0.1-SNAPSHOT.jar HRMS-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/HRMS/target/HRMS-0.0.1-SNAPSHOT.jar HRMS-0.0.1-SNAPSHOT.jar

ADD target/HRMS-0.0.1-SNAPSHOT.jar HRMS-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/HRMS/0.0.1-SNAPSHOT/HRMS-0.0.1-SNAPSHOT.jar HRMS-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "HRMS-0.0.1-SNAPSHOT.jar"]
