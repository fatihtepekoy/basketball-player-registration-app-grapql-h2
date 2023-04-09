FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
RUN mkdir -p logs
CMD java -DAPPLOGDIR=/logs -Dserver.port=$PORT $JAVA_OPTS -jar /app.jar
