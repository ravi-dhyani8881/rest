FROM openjdk:11-jre-slim
Expose 8081
# ADD target/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d/target/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar

ADD target/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d/0.0.1-SNAPSHOT/graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "graph-c12913ab-9e33-4e6a-8268-2d41ac41808d-0.0.1-SNAPSHOT.jar"]
