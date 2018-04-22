# RestFull 

É uma api REST que disponibiliza serviços de lançamento contábil.
## Arquitetura

* RestAPI
* Java 8
* Maven
* Spring boot 2.0
* Tomcat embedded
* Hibernate
* Swagger
* H2
* Junit

## Getting Started

Run RestFullApplication.java 
http://localhost:9999/swagger-ui.html


## Endpoints

[Postman Collection](https://github.com/lelodois/restfull/blob/master/LancamentoContabil.postman_collection.json)



|HTTP Request                                            |
|--------------------------------------------------------|
|POST /lancamentos-contabeis/ 
|GET  /lancamentos-contabeis/{id}                        | 
|GET  /lancamentos-contabeis/?contaContabil=1111021      |
|GET  /lancamentos-contabeis/_status/                    |
|GET  /lancamentos-contabeis/_status/?contaContabil=121  |


