# Assessment Test

## Job Title: Backend Developer

### Software requirements

- Java 17 or higher
- Maven 3.8+ or higher
- Postgres 14
- Kafka
- Redis
- Docker

### Running the Application

- Make sure all software requirements are installed
- Kafka and redis must be running, if not then enable them.
- Adjust the IP address and password configuration from the application.yml file in the trip and master services with the configuration you have installed.

- Build first in each service directory

```bash
# this is for build jar service trip
cd /your-directory/trip
mvn clean package -DskipTest
```

```bash
# this is for build jar service master
cd /your-directory/trip
mvn clean package -DskipTest
```

```bash
# this is for build images-container
cd /your-directory/according-inovation-test
docker compose up --build -d
```

- To import vehicle data and trip status, you can run a query with the data\_.sql file
- Also import the api collection with the name api.json to your postman
