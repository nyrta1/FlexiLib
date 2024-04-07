# YAML Library Service README

## Overview
This Java Spring Boot application serves as a YAML library service, providing CRUD operations for managing authors and books. It includes controllers, models, repositories, and services for handling author and book data. Additionally, it supports YAML format for both request and response payloads.

## Main Class
- **YamlLibraryServiceApplication:** Main class responsible for starting the application.

## Dependencies
- **Spring Cloud Eureka Client:** Enables the service to register itself with a Eureka server for service discovery.
- **Spring Cloud Config Client:** Allows the service to fetch configuration properties from a centralized configuration server.

## Configuration
- Configuration for connecting to PostgreSQL database and setting up Spring Cloud Config Client for fetching configuration properties.
- Jackson configuration to support YAML format for HTTP request and response payloads.
- Web configuration to set up content negotiation for YAML format.

## Author Controller
- **AuthorController:** Controller class responsible for handling HTTP requests related to authors.

### Endpoints
- **GET /api/yaml/authors:** Retrieves all authors in YAML format.
- **GET /api/yaml/authors/{uuid}:** Retrieves an author by UUID in YAML format.
- **POST /api/yaml/authors:** Saves a new author in YAML format.
- **PUT /api/yaml/authors:** Updates an existing author in YAML format.
- **DELETE /api/yaml/authors:** Deletes an author by UUID.

## Book Controller
- **BookController:** Controller class responsible for handling HTTP requests related to books.

### Endpoints
- **GET /api/yaml/books:** Retrieves all books in YAML format.
- **GET /api/yaml/books/{uuid}:** Retrieves a book by UUID in YAML format.
- **POST /api/yaml/books:** Saves a new book in YAML format.
- **PUT /api/yaml/books:** Updates an existing book in YAML format.
- **DELETE /api/yaml/books:** Deletes a book by UUID.

## Models
- **Author:** Represents an author entity with fields such as UUID and author name.
- **Book:** Represents a book entity with fields such as UUID, title, ISBN, published year, and authors.

## Repositories
- **AuthorRepository:** Repository interface for CRUD operations on author entities.
- **BookRepository:** Repository interface for CRUD operations on book entities.

## Services
- **AuthorService:** Service interface defining methods for managing authors.
- **BookService:** Service interface defining methods for managing books.

### Implementation
- **AuthorServiceImpl:** Implementation class for AuthorService, providing logic for author-related operations.
- **BookServiceImpl:** Implementation class for BookService, providing logic for book-related operations.

## Usage
- Run the application to start the YAML library service.
- Use HTTP requests to interact with the API endpoints for managing authors and books, with support for YAML format in request and response payloads.
