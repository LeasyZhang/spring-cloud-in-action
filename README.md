### About
This project come from the book 《Spring Cloud与Docker 微服务架构实战》.
But it has some difference because the book use Spring Cloud Camden SR4 version and
Docker 1.13.0 version.

### Build Tool Version
- Gradle 4.10
- Kibana 6.6.0
- RabbitMQ 3.7.11
- JDK 1.8

### Spring Boot&Cloud Version 
- SpringBoot 2.1.2.RELEASE
- SpringCloud Greenwich.RELEASE

### pre install
- [install rabbitmq](https://blog.csdn.net/u010046908/article/details/54773323)
- [install ELK](https://blog.csdn.net/callmepls1/article/details/79441505)

### build & run
- use ```gradle build``` in project root directory to build;
- each project can ben run independently, use ```gradle :moduleName:bootRun``` to run project,
for example use ```gradle :microservice-config-server:bootRun``` to boot microservice-config-server module.