# Store API - Spring Boot 3.5 Project

## ✅ Project Setup Complete

A fully functional Spring Boot 3.5 REST API with Gradle, Java 21, and Swagger documentation.

## Technology Stack
- **Framework**: Spring Boot 3.5.0
- **Java Version**: Java 21
- **Build Tool**: Gradle 8.5
- **API Documentation**: Swagger/Springdoc OpenAPI 2.0.2
- **Server Port**: 7777

## Running the Application
```bash
# Navigate to project directory
cd C:\Users\SURESH\MyProjects\Store-API

# Run with Gradle wrapper
.\gradlew.bat bootRun
```

The application will start on **http://localhost:7777**

## API Endpoints
### Products API (Base: `/api/products`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create new product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

## Access Swagger Documentation
- **Swagger UI**: http://localhost:7777/swagger-ui.html
- **API Docs JSON**: http://localhost:7777/v3/api-docs

## Sample API Request
```bash
# Get all products
curl http://localhost:7777/api/products

# Sample Response:
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "High-end gaming laptop",
    "price": 999.99
  },
  {
    "id": 2,
    "name": "Mouse",
    "description": "Wireless mouse",
    "price": 29.99
  },
  {
    "id": 3,
    "name": "Keyboard",
    "description": "Mechanical keyboard",
    "price": 149.99
  }
]
```

## Project Structure
```
src/main/java/com/store/
├── StoreApiApplication.java       # Main entry point
├── controller/
│   └── ProductController.java      # REST endpoints
├── model/
│   └── Product.java                # Data model
└── config/
    └── OpenAPIConfig.java          # Swagger configuration

gradle/wrapper/                     # Gradle wrapper files
build.gradle                        # Gradle build configuration
settings.gradle                     # Gradle settings
```

## Gradle Commands
```bash
# Build the project
./gradlew.bat build

# Run the application
./gradlew.bat bootRun

# Run tests
./gradlew.bat test

# Clean build
./gradlew.bat clean

# View dependencies
./gradlew.bat dependencies
```

## Configuration
All configuration is in `src/main/resources/application.yml`:
- Server port: 7777
- Application name: store-api
- Swagger UI path: /swagger-ui.html
- API docs path: /v3/api-docs

## ✅ Application Status
- **Running**: Yes
- **Port**: 7777
- **Swagger**: Accessible
- **Sample Data**: Pre-loaded (3 products)
