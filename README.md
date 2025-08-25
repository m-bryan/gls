## GLS ASSESSMENT – SaaS Backend System

### 1. Overview
gls is a **SaaS backend system** for logistics and transport companies.  
It manages **customers** and their **orders**, while ensuring that **notifications** are automatically triggered when order statuses are updated.

The app is based on a **microservices architecture**, with services communicating via **REST APIs** (synchronous) and **RabbitMQ messaging** (asynchronous).  
A shared external module (`shared-models`) ensures consistency of DTOs and entities across services.

### 2. Tech Stack Overview
the services are built using **Kotlin** and **Spring Boot**.


#### API Gateway
- **Spring Boot** (Web) for API providing
- **OpenAPI/Swagger** (Springdoc) for API documentation

---

#### Customers Service
- **PostgreSQL** as primary database (future)
- **H2** for development/testing
- Provides **CRUD operations** for customers

---

#### Orders Service
- **PostgreSQL** as primary database (future)
- **H2** for development/testing
- **RabbitMQ** for event publishing
- Handles **order creation and updates**

---

#### Notifications Service
- **RabbitMQ** for event consumption
- Processes **order update events** and notifies customer contacts

---

#### Shared-Models Module
- Centralized **DTOs, entities, and enums**
- Shared across all services as a **Gradle dependency**

![gls-poc-high-level.drawio.png](docs/gls-poc-high-level.drawio.png)