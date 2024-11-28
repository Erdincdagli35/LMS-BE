Dockerfile Oluştur

FROM openjdk:11-jdk-slim
COPY lms-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

-----------------------------------------

Docker Ignore Dosyası

target/
*.log
*.iml
.DS_Store
.idea/

----------------------------

Proje Build Et

mvn clean package

-------------------------------

Docker Image Oluştur

docker build -t lms:0.0.1 .

---------------------------------

Docker Container Çalıştır

docker run -d -p 9090:8080 --name lms lms:0.0.1


Docker Container Push to Docker Hub

