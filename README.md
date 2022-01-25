# REST API for calculating the shopping cart 

## Requirements

For building and running the application you need:

- [Docker] (https://docs.docker.com/get-docker/)

## Running the application locally
The best way to run the application locally is using Docker like so:
```shell
docker compose up 
```

## Testing the application
Swagger2 was used for testing the application. It is accessible via this link:
```shell
http://localhost:8080/swagger-ui/
```

## Used technologies

- Java 11
- Spring Boot
- Redis
- Lombok
- Docker

## Functionality

This REST API could be used for calculating the shopping cart. It has the only endpoint which you can access by URL:
 ```shell
http://localhost:8080/calculate-cart
```
Assumed that the input of the endpoint is the ShoppingCart object with relevant fields like:
- [Collection of input items]. Contains the item id and the number of items. 
- [Payment type]. It is considered to be enum with two values - card or cash.
- [User Address id]. This field is optional, in perspective the user address book could be realised and stored as seperate storage service. 

The output is CalculatedShopppingCart which has:
- [Collection of output items]. Contains the item id, the number of items and new field - the sum for position.
- [General sum]. Contains the result of calculating the sum for all positions.  

As input and output items has repeated fiels, they are extending from the base item class.

When accessing the endpoint, the API requests information from external URL using WebClient. If the URL was not found, the random float number rounded to 2 decimal places is returned as the item price. It is used as the stub in the test project to check the further flow, in real conditions ControllerExceptionHandler class would handle the exception.

Redis caching is used for caching the item prices to increase the productivity.

Based on the received values, the calculation occurs. 



