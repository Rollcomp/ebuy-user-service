FROM openjdk:8-alpine

ARG DIR=/opt/ebuy/registry-service

ENV DIR $DIR

WORKDIR $DIR

COPY target/*.jar $DIR/

ENTRYPOINT java  $JAVA_OPTS $DEBUG -cp ebuy-user-service-0.0.1-SNAPSHOT.jar org.ebuy.userservice.UserServiceApplication


