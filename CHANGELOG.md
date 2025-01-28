# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [2.0.0] - 2025-01-27

### Changed

- Base Architecture folders.
- Classes and tests.

### Added

- Entities and Models for relationships.
- Currency types soported and conversion.

## [1.0.0] - 2025-01-26

### Changed

- Base Architecture folders.
- Classes and tests.

### Added

- Redis to caching data for idempotency transactions.
- RabbitMQ for sender and consumers to retry failed transactions.
- Configuration classes.
- User's logic.
- Interceptors and externals Consumer/Producer classes.
- New exceptions.

## [0.0.2] - 2025-01-23

### Changed

- README.md updated.
- Classes and tests.

### Added

- OpenAPI/Swagger.
- Dev environment.
- JWT security.
- Exception Handler and exceptions.
- Transactionality on adapter.
- Integration Tests.



## [0.0.1] - 2025-01-23

### Added

- Basic V1 project structure implementing Hexagonal Architecture.
- Modules, plugins and libraries to build.
- Transaction model, entity, dto, mapper, controller, useCases, repository, port and adapter.
- Configuration Class for generating beans.
- Spring Security Class for getting a token for each request.
- Unit Tests.