FROM openjdk:19

COPY src/main/resources/templates/ /app/templates/

VOLUME /tmp
COPY target/root.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
