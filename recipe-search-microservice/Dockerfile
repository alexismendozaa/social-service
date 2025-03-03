# Usamos una imagen de Maven con JDK para compilar el código
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copiamos los archivos del proyecto y resolvemos dependencias
COPY pom.xml .
RUN mvn dependency:resolve

# Copiamos el código fuente y lo compilamos
COPY src/ ./src/
RUN mvn clean package -DskipTests

# Usamos una imagen de OpenJDK más ligera para ejecutar el servicio
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el JAR generado desde la fase de compilación
COPY --from=build /app/target/recipe-search-service.jar app.jar

# Exponemos el puerto de la aplicación
EXPOSE 8081

# Comando de arranque del servicio
ENTRYPOINT ["java", "-jar", "app.jar"]
