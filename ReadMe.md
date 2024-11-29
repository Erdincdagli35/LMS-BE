# LMS Backend - Library Management System

This repository contains the **backend implementation** of a simple **Library Management System (LMS)** built with Java and Spring Boot. The project is designed to handle core library functionalities such as managing books, authors, users, and loans, making it ideal for learning and exploring basic backend development with Spring Boot.

---

## **Features**

- **Book Management**: Add, update, delete, and retrieve book information.
- **Author Management**: Manage authors linked to books in the library.
- **User Management**: Handle library users and their data.
- **Loan Management**: Process book loans, including loan creation and return functionalities.
- **Database Integration**: Uses H2 Database for testing and development purposes.
- **Docker Support**: Easily deployable with Docker.

---

## **Technologies Used**

- **Java 11**
- **Spring Boot**
    - Spring Data JPA
    - Spring Web
- **H2 Database**
- **Docker**

---

## **Setup and Installation**

### **Local Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/Erdincdagli35/LMS-BE.git
   cd LMS-BE

## **Docker Deployment**

    ```bash
    docker pull erdincdagli/lms:latest
    docker run -d -p 8080:8080 erdincdagli/lms:latest

Docker Hub Link : https://hub.docker.com/repository/docker/erdincdagli/lms