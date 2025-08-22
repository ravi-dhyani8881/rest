# FROM openjdk:11-jre-slim
FROM eclipse-temurin:17-jdk
Expose 8081
# ADD target/RentedMachine-0.0.1-SNAPSHOT.jar RentedMachine-0.0.1-SNAPSHOT.jar

# ADD /home/runner/work/graphql/graphql/RentedMachine/target/RentedMachine-0.0.1-SNAPSHOT.jar RentedMachine-0.0.1-SNAPSHOT.jar

ADD target/RentedMachine-0.0.1-SNAPSHOT.jar RentedMachine-0.0.1-SNAPSHOT.jar

# ADD /home/runner/.m2/repository/com/spring/graph/RentedMachine/0.0.1-SNAPSHOT/RentedMachine-0.0.1-SNAPSHOT.jar RentedMachine-0.0.1-SNAPSHOT.jar
# /home/runner/.m2/repository/com/spring/graph/Prototype/0.0.1-SNAPSHOT/Prototype-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "RentedMachine-0.0.1-SNAPSHOT.jar"]
