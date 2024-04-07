# YAML Library Service README

## Overview
This Java Spring Boot application serves as a YAML library service, providing CRUD operations for managing authors and books. It includes controllers, models, repositories, and services for handling author and book data.

## Main Class
- **XmlLibraryServiceApplication:** Main class responsible for starting the application.

## Dependencies
- **Spring Cloud Eureka Client:** Enables the service to register itself with a Eureka server for service discovery.
- **Spring Cloud Config Client:** Allows the service to fetch configuration properties from a centralized configuration server.

## Configuration
- Configuration for connecting to PostgreSQL database and setting up Spring Cloud Config Client for fetching configuration properties.
- Web configuration to set default content type to XML for content negotiation.

## Author Controller
- **AuthorController:** Controller class responsible for handling HTTP requests related to authors.

### Endpoints
- **GET /api/xml/authors:** Retrieves all authors.
- **GET /api/xml/authors/{uuid}:** Retrieves an author by UUID.
- **POST /api/xml/authors:** Saves a new author.
- **PUT /api/xml/authors:** Updates an existing author.
- **DELETE /api/xml/authors:** Deletes an author by UUID.

## Author Model
- **Author:** Represents an author entity with fields such as UUID and author name.

## Author Repository
- **AuthorRepository:** Repository interface for CRUD operations on author entities.

## Author Service
- **AuthorService:** Service interface defining methods for managing authors.

### Implementation
- **AuthorServiceImpl:** Implementation class for AuthorService, providing logic for author-related operations.

## Book Controller
- **BookController:** Controller class responsible for handling HTTP requests related to books.

### Endpoints
- **GET /api/xml/books:** Retrieves all books.
- **GET /api/xml/books/{uuid}:** Retrieves a book by UUID.
- **POST /api/xml/books:** Saves a new book.
- **PUT /api/xml/books:** Updates an existing book.
- **DELETE /api/xml/books:** Deletes a book by UUID.

## Book Model
- **Book:** Represents a book entity with fields such as UUID, title, ISBN, published year, and authors.

## Book Repository
- **BookRepository:** Repository interface for CRUD operations on book entities.

## Book Service
- **BookService:** Service interface defining methods for managing books.

### Implementation
- **BookServiceImpl:** Implementation class for BookService, providing logic for book-related operations.

## Usage
- Run the application to start the YAML library service.
- Use HTTP requests to interact with the API endpoints for managing authors and books.
