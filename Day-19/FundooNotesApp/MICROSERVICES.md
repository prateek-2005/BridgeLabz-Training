# Fundoo Notes Microservices

This project has been split from a monolithic Spring Boot backend into a Maven multi-module microservices backend.

## Modules

- `eureka-server` runs service discovery on port `8761`.
- `api-gateway` runs Spring Cloud Gateway on port `8080`.
- `user-service` owns auth, users, JWT issuing, logout, MySQL `fundoo_users`, and Redis token state on port `8081`.
- `note-service` owns notes, MySQL `fundoo_notes`, and Redis token validation on port `8082`.
- `label-service` owns labels plus note-label mappings, MySQL `fundoo_labels`, and Redis token validation on port `8083`.
- `notification-service` owns notifications, consumes reminder events from RabbitMQ, MySQL `fundoo_notifications`, and Redis token validation on port `8084`.
- `reminder-service` owns reminders, publishes due reminders to RabbitMQ, MySQL `fundoo_reminders`, and Redis token validation on port `8085`.

## Gateway Routes

- `POST /auth/register` routes to `user-service`.
- `POST /auth/login` routes to `user-service`.
- `POST /auth/logout` routes to `user-service`.
- `/notes/**` routes to `note-service`.
- `/labels/**` routes to `label-service`.
- `/notifications/**` routes to `notification-service`.
- `/reminders/**` routes to `reminder-service`.

## Run Order

Start the infrastructure:

```bash
docker compose up -d
```

Start the services in this order:

```bash
./mvnw spring-boot:run -pl eureka-server
./mvnw spring-boot:run -pl user-service
./mvnw spring-boot:run -pl note-service
./mvnw spring-boot:run -pl label-service
./mvnw spring-boot:run -pl notification-service
./mvnw spring-boot:run -pl reminder-service
./mvnw spring-boot:run -pl api-gateway
```

Use the API through the gateway at `http://localhost:8080`.
