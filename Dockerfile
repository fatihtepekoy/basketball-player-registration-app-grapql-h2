FROM eclipse-temurin:17-jre-alpine
COPY target/*.jar app.jar
RUN mkdir -p logs
ENV JAVA_OPTS="-DAPPLOGDIR=/logs -Dserver.port=$PORT"
#EXPOSE 8080
#ENTRYPOINT ["java $JAVA_OPTS","-jar", "/app.jar"]
ENTRYPOINT java $JAVA_OPTS -jar /app.jar

