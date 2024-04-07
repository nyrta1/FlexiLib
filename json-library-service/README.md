# JSON Library Service README

## Overview
This Java Spring Boot application serves as a JSON library service, providing CRUD operations for managing authors and books. It includes controllers, models, repositories, and services for handling author and book data.

## Author Controller
- **AuthorController:** Controller class responsible for handling HTTP requests related to authors.

### Endpoints
- **GET /api/json/authors:** Retrieves all authors.
- **GET /api/json/authors/{uuid}:** Retrieves an author by UUID.
- **POST /api/json/authors:** Saves a new author.
- **PUT /api/json/authors:** Updates an existing author.
- **DELETE /api/json/authors:** Deletes an author by UUID.

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
- **GET /api/json/books:** Retrieves all books.
- **GET /api/json/books/{uuid}:** Retrieves a book by UUID.
- **POST /api/json/books:** Saves a new book.
- **PUT /api/json/books:** Updates an existing book.
- **DELETE /api/json/books:** Deletes a book by UUID.

## Book Model
- **Book:** Represents a book entity with fields such as UUID, title, ISBN, published year, and authors.

## Book Repository
- **BookRepository:** Repository interface for CRUD operations on book entities.

## Book Service
- **BookService:** Service interface defining methods for managing books.

### Implementation
- **BookServiceImpl:** Implementation class for BookService, providing logic for book-related operations.

## Configuration
- Configuration for connecting to PostgreSQL database and setting up Spring Cloud Config Server for centralized configuration management.

## Usage
- Run the application to start the JSON library service.
- Use HTTP requests to interact with the API endpoints for managing authors and books.
