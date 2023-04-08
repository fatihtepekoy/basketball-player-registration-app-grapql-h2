FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
COPY target/*.jar app.jar
RUN mkdir -p logs
ENV JAVA_OPTS="-DAPPLOGDIR=/logs"
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
