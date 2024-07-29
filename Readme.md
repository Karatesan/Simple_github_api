# Simple Github API Consumer

This is a minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app that consumes the GitHub API. 
It allows client to access all repositories of specific user.

## Requirements

To build and run the application, you’ll need:

- [JDK 21](https://www.oracle.com/pl/java/technologies/downloads/#java21)
- [Maven 3](https://maven.apache.org)

## Running the application locally
To run this app you don't have to do any configuration. You can optionally provide app with your personal github [token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens)
and inject it into [application.properties](src/main/resources/application.properties) `github.token` property.  
Without it your IP is [limited to 60 requests per hour](https://docs.github.com/en/rest/using-the-rest-api/rate-limits-for-the-rest-api?apiVersion=2022-11-28)

```shell
mvn spring-boot:run
```

## Copyright

You have all rights to copy, spread, and use this code as you see fit.
