FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
RUN mkdir -p logs
EXPOSE 8080
#ENTRYPOINT ["java $JAVA_OPTS","-jar", "/app.jar"]
#ENTRYPOINT java $JAVA_OPTS -jar /app.jar
#ENTRYPOINT ["java","-cp","app:app/lib/*","-DAPPLOGDIR=/logs -Dserver.port=8080","BasketballPlayerRegistrationApp"]
CMD java -DAPPLOGDIR=/logs -Dserver.port=8080 $JAVA_OPTS -jar /app.jar
#CMD java -cp app:app/lib/* -DAPPLOGDIR=/logs -Dserver.port=8080 com.fatih.basketball.BasketballPlayerRegistrationApp
