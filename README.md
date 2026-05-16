# Store API — Spring Boot 3.5

A fully functional Spring Boot 3.5 REST API with Gradle, Java 21, and Swagger documentation.

## Technology Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.5.0 |
| Language | Java 21 |
| Build Tool | Gradle 8.5 |
| API Docs | Springdoc OpenAPI 2.0.2 (Swagger) |
| Health Checks | Spring Boot Actuator |
| Deployment | Railway |

## Running Locally

```bash
# Clone and navigate to project
cd Store-API

# Run with Gradle wrapper (Linux/Mac)
./gradlew bootRun

# Run with Gradle wrapper (Windows)
.\gradlew.bat bootRun
```

The application starts on **http://localhost:7777**

## API Endpoints

Base path: `/api/products`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create new product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

## Swagger / API Docs

- Swagger UI: `http://localhost:7777/swagger-ui.html`
- OpenAPI JSON: `http://localhost:7777/v3/api-docs`

## Health Check

- `http://localhost:7777/actuator/health`

## Sample Request

```bash
# Get all products
curl http://localhost:7777/api/products

# Create a product
curl -X POST http://localhost:7777/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Headphones","description":"Noise cancelling","price":299.99}'
```

## Deploying to Railway

1. Push this repo to GitHub
2. Go to [railway.app](https://railway.app) and create a new project from your GitHub repo
3. Railway auto-detects Gradle and builds using `railway.json`
4. Set no environment variables — `PORT` is injected automatically by Railway
5. The health check endpoint (`/actuator/health`) is used by Railway to verify the deployment

Build command: `./gradlew bootJar -x test`
Start command: `java -jar build/libs/store-api-0.0.1-SNAPSHOT.jar`

## Project Structure

```
src/main/java/com/store/
├── StoreApiApplication.java       # Main entry point
├── controller/
│   └── ProductController.java     # REST endpoints
├── model/
│   └── Product.java               # Data model
└── config/
    └── OpenAPIConfig.java         # Swagger configuration

railway.json                       # Railway deployment config
Procfile                           # Process definition
build.gradle                       # Gradle build config
settings.gradle                    # Gradle settings
src/main/resources/application.yml # App configuration
```

## Gradle Commands

```bash
./gradlew bootRun        # Run the application
./gradlew bootJar        # Build fat JAR
./gradlew build          # Build + test
./gradlew test           # Run tests only
./gradlew clean          # Clean build artifacts
```

## Notes on Data Persistence

The current implementation uses an **in-memory static list** for product storage. Data resets on every restart. To add persistence, integrate a database (e.g., PostgreSQL via `spring-boot-starter-data-jpa` + Railway's Postgres addon).
