FROM eclipse-temurin:17-jre-alpine
COPY basketball-player-registration-app*.jar app.jar
RUN mkdir -p logs
ENV JAVA_OPTS="-DAPPLOGDIR=/logs -Dserver.port=$PORT"
#EXPOSE 8080
#ENTRYPOINT ["java $JAVA_OPTS","-jar", "/app.jar"]
ENTRYPOINT java $JAVA_OPTS -jar /app.jar

