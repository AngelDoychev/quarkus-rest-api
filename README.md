# quarkus-rest-api

This project uses Quarkus, the Supersonic Subatomic Java Framework.
It has an MVC architecture design with Rest API end points for CRUD operations on Employees.
The database is using Mysql and Jakarta to instantiate the Employee table in the quarkus_db schema.
I took advantage of the PanacheRepository interface which I implemented in the EmployeeRepository class
and added an extra service layer where the CRUD operations logic is done.
I used a record class of the Employee as a DTO so we don't expose the entity directly.
The endpoints are in the EmployeeResource class and play a crucial role as the bridge for request-response data.
All data traffic will be handled and filtered here. I utilized the @Path annotation to register endpoints and injected
the EmployeeService class.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```


## Dependecies

RESTEasy Reactive dan RESTEasy Reactive Jackson: these two libraries implement the Jakarta REST API commonly used in Spring, allowing each entity created to be generated into a database table.

Hibernate ORM with Panache: this library will provide the PanacheRepository class for ORM implementation.

MYSQL driver

Hibernate Validator: validates user input data.


<img src="https://i.postimg.cc/wMKmHdck/quarkus-get-By-Id.png" alt="getById">

<img src="https://i.postimg.cc/4dRfx4qn/quarkus-get-All.png" alt="getAll">

<img src="https://i.postimg.cc/vmFFWqzN/quarkus-add.png" alt="add">

<img src="https://i.postimg.cc/d0vNsznw/quarkus-update.png" alt="update">

<img src="https://i.postimg.cc/kD3Fjbpq/quarkus-delete.png" alt="delete">



Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-rest-api-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, Jakarta Persistence)
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
