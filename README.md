## Rodando o projeto

### Usando Maven + Spring Boot


Rodar o projeto
```shell
mvn spring-boot:run
```

[Acesse projeto](http://localhost:8080/)


Parar o projeto
```shell
mvn spring-boot:stop
```

### Usando Maven + Jar

Gerar o arquivo jar
```shell
mvn clean install
```

Executar o projeto
```shell
java -jar target/projeto-jsp.jar  
```

[Acesse projeto](http://localhost:8080/)


### Usando Docker-compose

```shell
docker-compose -f docker/docker-compose.yaml up
```

[Acesse projeto](http://localhost:8080/)


```shell
docker-compose -f docker/docker-compose.yaml down
```

### Usando SonarCloud

[Acesse o SonarCloud](https://sonarcloud.io/summary/overall?id=MouseWeb_projeto-jsp)

![image](https://github.com/MouseWeb/projeto-jsp/assets/40206726/f38893bf-d3a7-4c0b-85d6-52dccfcd9d4a)
![image](https://github.com/MouseWeb/projeto-jsp/assets/40206726/8bda8d05-f3a7-4afd-b27d-95bf3188c843)
![image](https://github.com/MouseWeb/projeto-jsp/assets/40206726/705b628e-cae5-45ae-9f2b-46ad3c0892fc)


### Usando Swagger

[Acesse o SWAGGER](http://localhost:8080/swagger-ui.html#/)

![image](https://github.com/MouseWeb/projeto-jsp/assets/40206726/fb283027-db0c-448c-869e-eaa601550f5c)

   
