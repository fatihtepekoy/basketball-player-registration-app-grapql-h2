# Spring Boot GraphQL H2 project

If you want to test out the application you can use the GraphiQL UI located at http://localhost:8080/graphiql

If you want to learn more you can check out my Spring for GraphQL with H2 article

TODO: https://fatihtepekoy.medium.com/

## Development 

- Run the Spring Boot application which will run on port 8080
- endpoint(application.properties) http://localhost:8080/apis/graphql/basketball

## Some notes about development and testing

 I used Java 17, which is the last approved version at the Enterprise level. Likewise, I used Spring Boot 3, Hibernate 7 (JPA) and H2 database, which are close to the latest versions.  Written according to Java code convention rules.
 
 I added unit tests for Controller, Service and Repository.  I've included some of them just to add and serve as an example. It can actually be removed. Not very logical tests. Here, I used the Mockito library to mock the beans other than the tested component.  I just used Junit as test runner. For test assertions, I mostly preferred the AssertJ library, which has more features.
 
 I used the Lombok library where necessary to reduce the boilerplate codes.
 
 I commented out the properties for MySql in Application properties and the dependency in the pom. They can be reactivated and easily run with MySql.
 
 I added orderType(ASC, DESC) and orderField to ListAllPlayers. Thus, it can be ordered according to the these two field.
 I added 2 custom exceptions for situations such as max team player, player not found.
 I have logged all changes and errors.

 Source codes are here;
 
 https://github.com/fatihtepekoy/basketball-player-registration-app-grapql-h2

 Here is the postman collection you can use to test it.
 
 https://api.postman.com/collections/7891468-9bb9d9b0-c038-4e2a-bac6-5cdad072c164?access_key=PMAT-01GXK40BY6FHBD7PN9RHKBTJEJ

 You can connect to the H2 database here. (user: fatih)
 https://localhost/h2-console
 User: Fatih
 database: jdbc:h2:mem:test
 password: (none, can be left blank)

