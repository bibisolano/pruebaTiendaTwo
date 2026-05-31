# Etapa 1: Compilación (Build)
# Usamos una imagen de Maven con JDK 21 para compilar
FROM maven:3.9.6-openjdk-25  AS build
workdir /app
COPY ..
RUN mvn-f pom.xml clean package -DskipTests


#Creacion imagen final 
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar. /app.jar
expose 80
ENTRYPOINT ["java", "-jar", "app.jar"]