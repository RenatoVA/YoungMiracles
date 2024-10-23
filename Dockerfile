FROM openjdk:21-jdk-slim
# Define la variable del archivo JAR
ARG JAR_FILE=target/YoungMircales-0.0.1.jar
# Copia el archivo JAR en el contenedor
COPY ${JAR_FILE} YoungMircales.jar
# Expone el puerto 8080
EXPOSE 8080
# Comando para ejecutar el archivo JAR en el contendor
ENTRYPOINT ["java", "-jar", "YoungMircalesjar"]