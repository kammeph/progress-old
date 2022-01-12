FROM maven:3-jdk-11-slim AS build
COPY ./ ./
RUN mvn clean
RUN mvn package -f "./pom.prod.xml"

FROM open-liberty:full-java11-openj9

COPY --chown=1001:0 \
    src/main/liberty/config \
    /config/

COPY --chown=1001:0 \
    --from=build /target/progress-api.war \
    /config/apps

EXPOSE 9080 9443

RUN configure.sh

