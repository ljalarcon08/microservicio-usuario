FROM eclipse-temurin:21-jdk-ubi9-minimal
RUN mkdir /app
COPY target/microservicio-usuario-0.0.1-SNAPSHOT.jar app/microservicio-usuario-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","app/microservicio-usuario-0.0.1-SNAPSHOT.jar","--spring.profiles.active=kubernete"]
#CMD ["java","-jar","app/microservicio-usuario-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]
# docker build --tag=microservicio-usuario:latest .
# docker run -p8088:8088 -d --net=docker-network --name=microservicio-usuario  microservicio-usuario:latest