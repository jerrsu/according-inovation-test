# Assessment Test

## Position: Backend Developer

### Software requirements

- Java 17 or higher
- Maven 3.8+ or higher
- Postgres 14
- Kafka
- Redis
- Docker

### Running the Application
- Make sure all software requirements are installed
- Adjust the configuration of the IP address and password from the application.yml file in the trip and master services with the configuration you have installed.
- Build first in the directory of each service
```bash
mvn clean package -DskipTest
```
- After that, Dockerize each service with the command
```bash
docker compose up --build -d
```
- To import vehicle data and trip status, you can run a query with the data_.sql file
- Also import the api collection with the name api.json into your postman
