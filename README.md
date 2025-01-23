# Payment Transaction Manager

**REST API to manage financial transactions with multi-currency support, idempotence, and compensation mechanisms, designed to be scalable and extensible.**

## Features

- **Multi-currency Support**: Handle transactions in various currencies with real-time conversion rates.
- **Idempotence**: Ensure duplicate requests do not affect the system state.
- **Compensation Mechanisms**: Automatic handling of failed transactions with retry and rollback support.
- **Scalable Architecture**: Designed for horizontal scalability and future extensibility.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** for database persistence.
- **Flyway** for database migrations.
- **OpenAPI/Swagger** for API documentation.
- **Spring Security** with JWT for authentication.
- **JUnit** and **MockMVC** for testing.
- **MySQL** as the relational database.

## Endpoints

### 1. **Create Transaction**
- **POST** `/transactions`
- Description: Initiates a financial transaction.
- Request Body:
  ```json
  {
    "userId": "12345",
    "amount": 100.50,
    "currency": "USD",
    "transactionType": "CARD"
  }
  - Response:
    {
        "transactionId": "abc123",
        "status": "PENDING"
    }