# Config Server Application README

## Overview
This Java Spring Boot application serves as a configuration server, providing centralized configuration management for other microservices in the system. It utilizes Spring Cloud Config Server to manage and distribute configuration properties.

## Main Class
- **ConfigServerApplication:** Main class responsible for starting the application.

## Dependencies
- **Spring Cloud Config Server:** Enables centralized configuration management and distribution.

## Configuration
- **server.port:** Specifies the port number on which the config server will run.
- **spring.profiles.active:** Defines the active profile for the config server. In this case, it's set to 'native', indicating that configuration files are stored locally.
- Configuration files are stored in the 'config' folder within the project directory.
- Each configuration file corresponds to a microservice and contains properties specific to that microservice.

## Microservice Configurations
- Configuration files are stored in YAML format under 'config' directory.
- Three microservices are configured: json-library-service, xml-library-service, and yaml-library-service.
- Each microservice configuration includes properties such as server port, Eureka server URL for service registration, and management tracing configuration.

## Usage
- Run the application to start the config server service.
- Ensure that the configuration files are correctly placed in the 'config' directory.
- Microservices in the system will fetch their configuration from this config server.
