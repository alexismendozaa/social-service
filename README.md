# Social Service - Microservices Architecture 🚀

## Overview 🌍
This **Social Service** project is a scalable and resilient system composed of **10 microservices** developed in **Java**. These microservices communicate via **RESTful APIs** and use **Event-Driven Architecture (EDA)** with AWS services like **SNS, SQS, and Kinesis** for asynchronous processing.

## 🏗️ Architecture & Technologies
- **Microservices** communication via **REST APIs** and **event-driven messaging** (AWS SNS, SQS, Kinesis).
- **DDoS & EDoS Protection** integrated into each microservice to prevent malicious attacks.
- **Documentation** with **Swagger** for API discovery and usage.
- **Monitoring & Alerting** via **Grafana, Prometheus, Kibana** for real-time insights and logging.
- **Cloud Deployment** with AWS services.

## 🎯 Design Principles
This system follows key software design principles:
1. **SOLID** - Ensuring maintainable, scalable, and testable code.
2. **KISS (Keep It Simple, Stupid)** - Avoiding unnecessary complexity in microservices.
3. **DRY (Don't Repeat Yourself)** - Reusing components and avoiding duplication.
4. **YAGNI (You Ain't Gonna Need It)** - Only implementing necessary features.

## 📜 Microservices
1. **User Service** - Manages authentication & user profiles.
2. **Post Service** - Handles social media posts and media uploads.
3. **Comment Service** - Manages comments on posts.
4. **Like Service** - Tracks likes and reactions.
5. **Notification Service** - Sends real-time notifications.
6. **Follow Service** - Manages user connections and follows.
7. **Search Service** - Implements search functionality.
8. **Recommendation Service** - Suggests content using ML algorithms.
9. **Analytics Service** - Aggregates and visualizes user engagement data.
10. **Security Service** - Implements DDoS & EDoS protection and authentication.

## 📊 Monitoring & Alerting
To ensure system reliability and health, the following tools are used:
- **Grafana & Prometheus** - Performance monitoring and alerting.
- **Kibana & ELK Stack** - Logging and centralized analysis.
- **AWS CloudWatch** - Cloud resource monitoring.

## 📜 API Documentation
All endpoints are documented with **Swagger**, allowing easy exploration and testing.

## 🚀 Getting Started
1. Clone the repository:
   \\\sh
   git clone https://github.com/alexismendozaa/social-service.git
   cd social-service
   \\\
2. Start the microservices:
   \\\sh
   docker-compose up -d
   \\\
3. Access the Swagger documentation:
   \\\
   http://localhost:8080/swagger-ui.html
   \\\

## 🤝 Contributions
Feel free to contribute! Open issues, submit PRs, or suggest improvements.

## 📜 License
MIT License. See **LICENSE** file for details.


