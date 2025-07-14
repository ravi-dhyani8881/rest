# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/graph-4cd42e04-df35-48c7-828e-f38dad5a8254/target/graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar

ADD target/graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/graph-4cd42e04-df35-48c7-828e-f38dad5a8254/0.0.1-SNAPSHOT/graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "graph-4cd42e04-df35-48c7-828e-f38dad5a8254-0.0.1-SNAPSHOT.jar"]
