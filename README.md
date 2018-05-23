# spring-boot-microservices-stock
A stock management as a Rest-Microservice

## Description
This project is to develop a stock management as a Rest-Microservice in Java using Spring Cloud Netflix Eureka. 

The stock management maintains the current stock amount for a product. The stock can be increased (refill) or decreased (client buys a product). The stock should be maintained on a per-product basis.

Clone it and either load into your favorite IDE or use maven directly.

## Using an IDE to run the services

You can run the system in your IDE by running the three server classes in order: _EurekaServiceApplication_, _ProductCatalogServiceApplication_ and _EdgeServiceApplication_. Each is a Spring Boot application using embedded Tomcat. In Spring Tool Suite use `Run As ... Spring Boot App` otherwise just run each as a Java application - each has a static `main()` entry point. You can use `mvn spring-boot:run` on each folder.

When all service are running, to see that all is correct, you can open the Eureka dashboard [http://localhost:8761](http://localhost:8761) in your browser to see that the `PRODUCT-CATALOG-SERVICE` and `EDGE-SERVICE` applications have registered.  

If you want test the `PRODUCT-CATALOG-SERVICE`, you can open [http://localhost:8762/products](http://localhost:8762/products) to see all products pre-loaded by default of [http://localhost:8762/products/{id}](http://localhost:8762/products/{id}), where you can replace _{id}_ by 1,2...5, to see a concret product. 

If you want test the `EDGE-SERVICE`, you can open [http://localhost:8763/products](http://localhost:8763/products) to see the products pre-loaded by default.

## The Angular client to test the services

The Angular project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.6.5.

To run this client it is necessary to have the [npm](https://www.npmjs.com/) installed and execute into the folder `stock-angular-client` the command `npm install`. After that you can execute `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build (in the directory `/dist` you can see a this build) 

To run the application, execute `npm start` or `ng serve` for a developer server. Navigate to [http://localhost:4200/](http://localhost:4200/). The application will automatically reload if you change any of the source files.

In this url, you can see a list of product with 2 buttons: one of them to add a new product, and the other to retire a product (all changes are shown in the same list).


