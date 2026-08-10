# Etapa 1: Compilación (Build)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copiamos primero el pom.xml para aprovechar la caché
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copiamos el código fuente
COPY src ./src

# Compilamos
RUN mvn clean package -DskipTests


# Etapa 2: Ejecución (Runtime)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Usuario sin privilegios
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiamos el JAR generado por Maven y lo renombramos a app.jar
COPY --from=build /app/target/tiendatwo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 80

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]