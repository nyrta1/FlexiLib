# API Gateway Application README

## Overview
This Java Spring Boot application serves as the API gateway for routing requests to appropriate microservices. It utilizes Spring Cloud Discovery Client for service discovery and routing.

## Main Class
- **ApiGatewayApplication:** Main class responsible for starting the application.

## Dependencies
- **Spring Cloud Discovery Client:** Enables service discovery and registration with a service registry (Eureka).
- **Spring Cloud Gateway:** Provides routing and filtering capabilities for HTTP requests.

## Configuration
- **server.port:** Specifies the port number on which the API gateway will run.
- **spring.application.name:** Defines the name of the API gateway application.
- **eureka.client.service-url.defaultZone:** Specifies the URL of the Eureka server for service registration and discovery.
- **management.tracing.sampling.probability:** Configures distributed tracing sampling probability.

## Routing Configuration
- Configures routing rules for forwarding requests to corresponding microservices based on URI paths.
- Each route definition consists of an ID, URI of the target microservice, and predicates to match request paths.

## Usage
- Run the application to start the API gateway service.
- Ensure that Eureka server is running and accessible at the specified URL for service discovery.
- Requests to `/api/json/**`, `/api/xml/**`, and `/api/yaml/**` will be routed to corresponding microservices.
