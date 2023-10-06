FROM openjdk:19
COPY target/Spring1-1.0-SNAPSHOT.jar /app.jar
ENV SPRING_PROFILES_ACTIVE=production
CMD ["java", "-jar", "/app.jar"]