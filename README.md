# Product API - Spring Boot Application

## Project Overview

This Spring Boot application is built to manage a product catalog with CRUD operations using RESTful APIs. The APIs allow you to create, retrieve, update, and delete products, as well as fetch the details of specific products. 

## Features

- User authentication with JWT tokens
- Account creation and login
- Product management
- Cart functionality
- Wishlist management

## Database

The project uses **H2** as an in-memory database for testing purposes.

### H2 Database Details:
- **URL**: `jdbc:h2:mem:testdb`
- **Driver Class**: `org.h2.Driver`
- **Username**: `admin`
- **Password**: (No password is required)

You can access the H2 console from the following URL after running the application:
http://localhost:8080/h2-console


- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `admin`
- **Password**: (Leave it blank)

## Authentication
The API uses JWT token-based authentication to secure endpoints. You will need to log in with a valid user account to obtain a token for accessing secured endpoints.
### Default Users
- Admin:
-- Email: admin@admin.com
-- Password: test
- Regular User:
-- Email: test@test.com
-- Password: test

## Documentation

The API documentation is available at the following URL:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

You can use Swagger to explore and test all available services, including:

- **Account Management**: Create new accounts.
- **Authentication**: Log in and obtain JWT tokens.
- **Products**: Manage products (Admin only).
- **Cart**: Add, remove, and view items in the shopping cart.
- **Wishlist**: Add, remove, and view items in the wishlist.

## Running the Project

To run the project, follow these steps:

1. Clone the repository.
2. Make sure you have **Java 17 or later** installed.
3. Navigate to the project directory and use the following command to run the application:
   ```bash
   ./mvnw spring-boot:run

4. Access the Swagger documentation at:
```bash
   http://localhost:8080/swagger-ui/index.html
