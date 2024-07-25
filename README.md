# Galaxy Simulation Project

## Overview
This project simulates a solar system with planets orbiting around a central sun, providing a visual representation using React Three Fiber and a backend service built with Spring Boot. The application includes a frontend for visualization and a backend for managing and retrieving solar system data, including planet positions and weather conditions.

## Project Structure
```bash
/project-root
  /backend
    Dockerfile
    src/
      main/
      test/
    pom.xml
  /frontend
    Dockerfile
    public/
    src/
      components/
        OrbitalSpheres.tsx
        Planet.tsx
        Skybox.tsx
        SolarSystemInfo.tsx
      App.tsx
      main.tsx
    package.json
  docker-compose.yml
```

# Backend
Technology Stack: Java, Spring Boot, MySQL

## Description:

Manages solar system data including planets, their positions, and weather conditions.
Provides RESTful API endpoints for creating, retrieving, updating, and deleting data related to the solar system.
Connects to a MySQL database to persist data.
Key Features:

# API Endpoints:
/api/solarSystem - Manage solar system data.
/api/posPlanetDay - Manage planet positions by day.

# Database Configuration:
Uses MySQL for data persistence.
Automatically updates the database schema at startup.

# Docker Setup
docker-compose.yml: Defines services for running the backend, frontend, and MySQL database in Docker containers.

# Services:

galaxy-db: MySQL database service.
galaxy-app: Spring Boot backend service.
frontend: React frontend service


# API Endpoints ( some endpoints )


## PeriodController
POST /api/periods

### Descripción: Crear un nuevo periodo.
Request Body: Period
Response: Period creado
GET /api/periods/{periodId}

### Descripción: Obtener un periodo por ID.
Path Variable: periodId
Response: Period encontrado o HttpStatus.NOT_FOUND
GET /api/periods

### Descripción: Obtener todos los periodos.
Response: Lista de Period
PUT /api/periods/{periodId}

### Descripción: Actualizar un periodo por ID.
Path Variable: periodId
Request Body: Period actualizado
Response: Period actualizado o HttpStatus.NOT_FOUND
DELETE /api/periods/{periodId}

### Descripción: Eliminar un periodo por ID.
Path Variable: periodId
Response: HttpStatus.NO_CONTENT o HttpStatus.NOT_FOUND
GET /api/periods/wheaterCondition/{wheaterCondition}

### Descripción: Obtener periodos por condición climática.
Path Variable: wheaterCondition
Response: Lista de Period
PlanetController
POST /api/planets

### Descripción: Crear un nuevo planeta.
Request Body: Planet
Response: Planet creado
GET /api/planets/{planetId}

### Descripción: Obtener un planeta por ID.
Path Variable: planetId
Response: Planet encontrado o HttpStatus.NOT_FOUND
GET /api/planets

### Descripción: Obtener todos los planetas.
Response: Lista de Planet
PUT /api/planets/{planetId}

### Descripción: Actualizar un planeta por ID.
Path Variable: planetId
Request Body: Planet actualizado
Response: Planet actualizado o HttpStatus.NOT_FOUND
DELETE /api/planets/{planetId}

### Descripción: Eliminar un planeta por ID.
Path Variable: planetId
Response: HttpStatus.NO_CONTENT o HttpStatus.NOT_FOUND
PosPlanetDayController
POST /api/posPlanetDay

### Descripción: Crear un nuevo PosPlanetDay.
Request Body: PosPlanetDay
Response: PosPlanetDay creado
GET /api/posPlanetDay/{posPlanetDayId}

### Descripción: Obtener un PosPlanetDay por ID.
Path Variable: posPlanetDayId
Response: PosPlanetDay encontrado o HttpStatus.NOT_FOUND
GET /api/posPlanetDay

### Descripción: Obtener todos los PosPlanetDay.
Response: Lista de PosPlanetDay
PUT /api/posPlanetDay/{posPlanetDayId}

### Descripción: Actualizar un PosPlanetDay por ID.
Path Variable: posPlanetDayId
Request Body: PosPlanetDay actualizado
Response: PosPlanetDay actualizado o HttpStatus.NOT_FOUND
DELETE /api/posPlanetDay/{posPlanetDayId}

### Descripción: Eliminar un PosPlanetDay por ID.
Path Variable: posPlanetDayId
Response: HttpStatus.NO_CONTENT o HttpStatus.NOT_FOUND
GET /api/posPlanetDay/planet/{planetId}

### Descripción: Obtener todos los PosPlanetDay por ID de planeta.
Path Variable: planetId
Response: Lista de PosPlanetDay
GET /api/posPlanetDay/date/{date}

### Descripción: Obtener PosPlanetDay por fecha.
Path Variable: date
Response: Lista de PosPlanetDay
SolarSystemController
POST /api/solarSystem

### Descripción: Crear un nuevo sistema solar.
Request Body: SolarSystem
Response: SolarSystem creado
GET /api/solarSystem/{solarSystemId}

### Descripción: Obtener un sistema solar por ID.
Path Variable: solarSystemId
Response: SolarSystem encontrado o SolarSystemNotFoundException
GET /api/solarSystem

### Descripción: Obtener todos los sistemas solares.
Response: Lista de SolarSystem
PUT /api/solarSystem/{solarSystemId}

### Descripción: Actualizar un sistema solar por ID.
Path Variable: solarSystemId
Request Body: SolarSystem actualizado
Response: SolarSystem actualizado o SolarSystemNotFoundException
DELETE /api/solarSystem/{solarSystemId}

### Descripción: Eliminar un sistema solar por ID.
Path Variable: solarSystemId
Response: HttpStatus.NO_CONTENT o SolarSystemNotFoundException
GET /api/solarSystem/date/{solarDate}

### Descripción: Obtener un sistema solar por fecha.
Path Variable: solarDate
Response: SolarSystem encontrado o SolarSystemNotFoundException
GET /api/solarSystem/max-perimeter

### Descripción: Obtener el sistema solar con el perímetro máximo.
Response: SolarSystem encontrado o SolarSystemNotFoundException
GET /api/solarSystem/drought-days

### Descripción: Obtener todos los días de sequía.
Response: Lista de días de sequía
GET /api/solarSystem/rainy-days

### Descripción: Obtener todos los días de lluvia.
Response: Lista de días de lluvia


