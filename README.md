# SocialVibe

Une application de réseau social construite avec Spring Boot en Clean Architecture dans le cadre de la matiere Conception d'Application 

## Technologies
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL
- Swagger/OpenAPI

## Architecture
```java
fr.rana.baedaar/
├── adapter/
│   ├── controller/    # API endpoints
│   ├── docs/         # Documentation
│   ├── infrastructure/# Technical implementations
│   └── messaging/    # Message handlers
├── application/      # Use cases layer
│   ├── dto/         # Data transfer objects
│   ├── event/       # Application events
│   └── services/    # Business logic
└── domain/          # Business rules
├── event/       # Domain events
├── model/       # Domain entities
└── repository/  # Repository interfaces
```
## Commandes

- brew services start kafka
- brew services start zookeeper
- mailhog


## Documentation 
- API documentation: http://localhost:8085/swagger-ui.html
- Mailhog : http://localhost:8025
