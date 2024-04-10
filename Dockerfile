# Usar la imagen base de OpenJDK 17 alpine
FROM openjdk:17-alpine

# Opcional: establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo .jar de tu aplicación al contenedor
COPY ./target/*.jar /app/app.jar

# exponer pùerto
EXPOSE 8080

# Comando para ejecutar tu aplicación
CMD ["java", "-jar", "/app/app.jar"]