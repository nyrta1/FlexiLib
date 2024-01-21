# DataFormatMicroservices

## Project Structure

microservices-project/
|-- library-service/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.library/
|   |               +-- controller/
|   |               +-- model/
|   |               +-- service/
|   +-- pom.xml
|
|-- config-service/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.config/
|   |               +-- (configuration files)
|   +-- pom.xml
|
|-- json-microservice/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.json/
|   |               +-- controller/
|   |               +-- model/
|   |               +-- service/
|   +-- pom.xml
|
|-- xml-microservice/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.xml/
|   |               +-- controller/
|   |               +-- model/
|   |               +-- service/
|   +-- pom.xml
|
|-- csv-microservice/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.csv/
|   |               +-- controller/
|   |               +-- model/
|   |               +-- service/
|   +-- pom.xml
|
|-- yaml-microservice/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.yaml/
|   |               +-- controller/
|   |               +-- model/
|   |               +-- service/
|   +-- pom.xml
|
|-- kafka-producer/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.kafka/
|   |               +-- producer/
|   +-- pom.xml
|
|-- kafka-consumer/
|   |-- src/
|   |   +-- main/
|   |       +-- java/
|   |           +-- com.example.kafka/
|   |               +-- consumer/
|   +-- pom.xml
|
|-- pom.xml (parent project)