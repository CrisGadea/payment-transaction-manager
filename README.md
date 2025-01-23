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
- **MySQL 8+** as the relational database.

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
  ```
- Response:
  ```json
    {
        "transactionId": "abc123",
        "status": "PENDING"
    }
  ```
### 2. **Get Transaction Status**
   •	GET /transactions/{id}
   •	Description: Retrieves the status of a specific transaction.

### 3. **List Transactions**
   •	GET /transactions
   •	Query Params: userId, status, sortBy, order.
   •	Description: Lists transactions with optional filters and sorting.

## Getting Started

### Prerequisites
•	Java 17
•	Maven 3.8+
•	MySQL 8+ (or your preferred RDBMS)

### Installation
1.	Clone the repository:
```shell
    git clone https://github.com/your-username/payment-transaction-manager.git
    cd payment-transaction-manager
```
2. Configure the database in application.yml:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/transaction_db
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: validate
```
3. Run Application:
```shell
mvn spring-boot:run
```
4. Running Tests:
```shell
mvn test
```

## Architecture

The project follows a Hexagonal Architecture, with clear separation of concerns:
•	Controllers: Handle HTTP requests and responses.
•	Domain Services: Contain business logic.
•	Infrastructure: Manage database interactions and external API calls.

## Author

Cristian Gadea