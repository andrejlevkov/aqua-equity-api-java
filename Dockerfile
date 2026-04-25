FROM eclipse-temurin:20-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:20-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:mysql://qe71st.h.filess.io:3307/aqua_equity_greaterlow?useSSL=false&serverTimezone=UTC
ENV SPRING_DATASOURCE_USERNAME=aqua_equity_greaterlow
ENV SPRING_DATASOURCE_PASSWORD=586798d703e7f33f1bd4aa0d0d2222cb4c13926f
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=validate
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]