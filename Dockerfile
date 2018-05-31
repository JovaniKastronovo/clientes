FROM openjdk:8u151-jre-slim
MAINTAINER jovani.arzate@elektra.com.mx"
COPY servicio-cliente.jar /opt/servicio-cliente.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Xms256m", "-Xmx256m", "-jar", "/opt/servicio-cliente.jar"]
