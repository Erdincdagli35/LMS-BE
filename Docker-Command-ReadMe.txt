Create Dockerfile 

FROM openjdk:11-jdk-slim
COPY lms-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

-----------------------------------------

Create Docker Ignore file

target /
*.log
*.iml
.DS_Store
.idea/

----------------------------

Build project
mvn clean package

-------------------------------

Create Docker Image 

docker build -t lms:0.0.1 .

---------------------------------

Run Docker Container 

docker run -d -p 9090:8080 --name lms lms:0.0.1


Docker Container Push to Docker Hub

