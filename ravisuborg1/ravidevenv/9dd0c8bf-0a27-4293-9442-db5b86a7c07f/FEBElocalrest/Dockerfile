# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/FEBElocalrest-0.0.1-SNAPSHOT.jar FEBElocalrest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/FEBElocalrest/target/FEBElocalrest-0.0.1-SNAPSHOT.jar FEBElocalrest-0.0.1-SNAPSHOT.jar

ADD target/FEBElocalrest-0.0.1-SNAPSHOT.jar FEBElocalrest-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/FEBElocalrest/0.0.1-SNAPSHOT/FEBElocalrest-0.0.1-SNAPSHOT.jar FEBElocalrest-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "FEBElocalrest-0.0.1-SNAPSHOT.jar"]
