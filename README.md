# DriveX Car Inventory Management

A modern Spring Boot web application for managing a car inventory with a clean admin dashboard, full CRUD operations, and real-time inventory metrics.

## Overview

DriveX helps you:

- Add new cars with brand, model, year, fuel type, image URL, and price
- View all cars in a dashboard-style table
- Edit existing car records
- Delete cars from inventory
- Track summary metrics such as total cars, total inventory value, and average price

The application uses server-side rendering with Thymeleaf and persists data with Spring Data JPA and MySQL.

## Tech Stack

- Java 17
- Spring Boot 4.0.2
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL Connector/J
- Maven Wrapper

## Project Structure

src/main/java/com/drivex/carinventory

- DrivexApplication.java -> Spring Boot entry point
- controller/CarController.java -> Web routes and page flow
- service/CarService.java -> Business logic and inventory metrics
- repository/CarRepository.java -> JPA repository
- model/Car.java -> Car entity

src/main/resources

- application.properties -> Application and database configuration
- templates/car-list.html -> Main dashboard/list page
- templates/add-car.html -> Add form
- templates/edit-car.html -> Edit form

## Data Model

The Car entity contains:

- id (Long)
- brand (String)
- model (String)
- year (int)
- fuelType (String)
- price (double)
- imageUrl (String)

## Prerequisites

Install the following before running:

- JDK 17
- MySQL 8+ (or compatible)

Optional:

- VS Code with Java Extension Pack

## Configuration

Default config in src/main/resources/application.properties:

- server port: 8080
- datasource url: jdbc:mysql://localhost:3306/carinventory
- datasource username: caruser
- datasource password: carpass123
- hibernate ddl-auto: update

Update these values as needed for your local environment.

## Database Setup (MySQL)

Run the following SQL once:

```sql
CREATE DATABASE carinventory;
CREATE USER 'caruser'@'localhost' IDENTIFIED BY 'carpass123';
GRANT ALL PRIVILEGES ON carinventory.* TO 'caruser'@'localhost';
FLUSH PRIVILEGES;
```

If you already have a MySQL user, you can skip user creation and only grant privileges.

## Run the Application

From the project root:

Windows (PowerShell or CMD):

```bash
.\mvnw.cmd spring-boot:run
```

macOS/Linux:

```bash
./mvnw spring-boot:run
```

Open in browser:

```text
http://localhost:8080/
```

## Build and Test

Run tests:

```bash
.\mvnw.cmd test
```

Package application:

```bash
.\mvnw.cmd clean package
```

Run packaged JAR:

```bash
java -jar target/drivex-0.0.1-SNAPSHOT.jar
```

## Route Map

- GET / -> Inventory dashboard and car list
- GET /showNewCarForm -> Add car page
- POST /saveCar -> Create or update car
- GET /showEditCarForm/{id} -> Edit car page
- GET /deleteCar/{id} -> Delete car and redirect

## Troubleshooting

### Application fails to start

- Verify Java version is 17:

```bash
java -version
```

- Verify MySQL is running and reachable on localhost:3306
- Verify database credentials in application.properties

### Port 8080 already in use

Change the port in src/main/resources/application.properties:

```properties
server.port=8081
```

Then open the new port in the browser.

### Access denied for MySQL user

Re-check username/password and re-run GRANT statements.

## Current Test Coverage

- Basic Spring context load test in src/test/java/com/drivex/carinventory/DrivexApplicationTests.java

## Future Enhancements

- Input validation and user-friendly error messages
- Search, filter, and pagination for inventory table
- REST API endpoints for integration
- Authentication and role-based access
- Unit and integration tests for service and controller layers

## Author

DriveX Car Inventory Management

This is an inhouse internship project helping reflect the Java Springboot concepts understood during the Internship.
