# Calculadora Rest API Spring Boot

## Compilar

```bash
mvn clean install
```

## Ejecutar

```bash
mvn spring-boot:run
```

## Test con curl

Aquí tienes ejemplos de comandos `curl` para cada operación de tu API:

### Operación de suma

curl -X GET 'http://localhost:8080/calculadora/fazerOp?num1=5&num2=3&op=+'

### Operación de resta

curl -X GET 'http://localhost:8080/calculadora/fazerOp?num1=5&num2=3&op=-'

### Operación de multiplicación

curl -X GET 'http://localhost:8080/calculadora/fazerOp?num1=5&num2=3&op=\*'

### Operación de división

curl -X GET 'http://localhost:8080/calculadora/fazerOp?num1=5&num2=3&op=/'

## Ejecutar test

```bash
mvn test
```

## Dockerización de la aplicación

### Crear imagen de la aplicación

```bash
docker build -t calculadora-rest-api .
```

### Ejecutar contenedor de la aplicación

```bash
docker run -p 8080:8080 calculadora-rest-api
```
