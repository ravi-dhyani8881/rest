# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/bankrule-0.0.1-SNAPSHOT.jar bankrule-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/bankrule/target/bankrule-0.0.1-SNAPSHOT.jar bankrule-0.0.1-SNAPSHOT.jar

ADD target/bankrule-0.0.1-SNAPSHOT.jar bankrule-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/bankrule/0.0.1-SNAPSHOT/bankrule-0.0.1-SNAPSHOT.jar bankrule-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "bankrule-0.0.1-SNAPSHOT.jar"]
