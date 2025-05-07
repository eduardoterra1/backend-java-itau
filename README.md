# API de Estatísticas de Transações

Este projeto é uma API REST desenvolvida em **Java 17** utilizando o **Spring Boot**. A API é responsável por receber transações financeiras e fornecer estatísticas em tempo real sobre essas transações.

## ✨ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Validation
  - Spring DevTools
- **Maven** (gerenciador de dependências)
- Empacotamento via **JAR**

## Práticas adotadas

- API REST
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## 📌 Objetivo do Projeto

Criar uma API REST que:

1. Recebe transações contendo valor e data/hora.
2. Retorna estatísticas em tempo real com base nas transações dos últimos 60 segundos.

As estatísticas incluem:

- Soma (`sum`)
- Média (`avg`)
- Valor máximo (`max`)
- Valor mínimo (`min`)
- Quantidade de transações (`count`)

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/desafioitau-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📥 Endpoints

### POST `/transacoes`

Recebe uma nova transação.

#### Request Body
```json
{
  "valor": 12.5,
  "timestamp": "2025-05-07T14:30:00.000Z"
}


### POST `/estatísticas`

Retona dados da API.

#### Request Body
```json
{
  {
    "count": 1,
    "sum": 123.45,
    "avg": 123.45,
    "min": 123.45,
    "max": 123.45
}
}