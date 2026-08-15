# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# Stage 2: Tomcat
# =========================
FROM tomcat:10.1-jdk17-temurin

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Create non-root user
RUN groupadd -r appgroup && \
    useradd -r -g appgroup appuser

# Copy WAR
COPY --from=builder /app/target/SpringMVCSearch.war \
    /usr/local/tomcat/webapps/ROOT.war

# Give application user ownership
RUN chown -R appuser:appgroup /usr/local/tomcat

# Run Tomcat as non-root
USER appuser

EXPOSE 8080

CMD ["catalina.sh", "run"]
