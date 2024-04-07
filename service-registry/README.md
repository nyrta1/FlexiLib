# Service Registry Application README

## Overview
This Java Spring Boot application serves as a service registry using Eureka server, enabling microservices to register themselves and discover other services in the system.

## Main Class
- **ServiceRegistryApplication:** Main class responsible for starting the application.

## Dependencies
- **Spring Cloud Netflix Eureka Server:** Provides service discovery and registration capabilities.

## Configuration
- **server.port:** Specifies the port number on which the Eureka server will run.
- **spring.application.name:** Defines the name of the service registry application.
- **eureka.instance.hostname:** Specifies the hostname of the Eureka server instance.
- **eureka.client.register-with-eureka:** Indicates whether this service instance should register with the Eureka server.
- **eureka.client.fetch-registry:** Indicates whether this service instance should fetch registry information from the Eureka server.
- **eureka.client.service-url.defaultZone:** Specifies the URL of the Eureka server.

## Usage
- Run the application to start the Eureka server service.
- Microservices in the system will register themselves with this Eureka server for service discovery.
- Ensure that other microservices are configured to fetch registry information from this Eureka server.
