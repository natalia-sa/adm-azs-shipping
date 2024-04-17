# adm-azs-shipping

> Rest API to manage customer freights 

### Technologies Used

- **Java**

- **Spring-boot**

- **Maven**

- **PostgreSQL**

- **Flyway**

- **Docker**

- **Swagger**

### Requirements

- You need to have Docker installed to run this app

### Set up

1. Clone the repository to your local machine.
2. Navigate to the project directory that you just cloned
3. Run `docker compose up`
4. Open swagger to use the API: [Swagger UI](http://localhost:8080/swagger-ui/index.html)

### Main endpoints

- **POST /customer**: Create a new customer.
  - Example Request Body:
    ```json
    {
      "name": "Company1",
      "cnpj": "12356432345678"
    }
    ```
- **POST /customer-freight**: Create a customer freight: entity responsible to store the freight properties of a customer.
  - Example Request Body:
    ```json
    {
      "customerId": "1",
      "freightProperties": { "weight": "INTEGER" }
    }
    ```
- **POST /freight**: Create a new freight. The properties passed as input should have the same attributes specified in the respective customer freight.
  - Example Request Body:
    ```json
    {
      "customerFreightId": "1",
      "properties": { "weight": 3 }
    }
    ```
