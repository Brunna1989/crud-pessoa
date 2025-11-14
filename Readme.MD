# CRUD de Pessoas e Endereços — Spring Boot + H2

Este projeto é uma aplicação **CRUD completa** utilizando **Spring Boot**, **JPA/Hibernate**, **Banco de Dados H2**, **Lombok** e arquitetura limpa com **Services**, **Controllers**, **Repositories** e **tratamento de exceções personalizadas**.

A aplicação gerencia duas entidades:

- **Pessoa** (nome, CPF, data de nascimento, idade calculada automaticamente)
- **Endereço** (rua, número, bairro, cidade, estado e CEP)

Com um relacionamento **um-para-muitos**:  
➡ **Uma Pessoa pode possuir vários Endereços.**

---

## ✨ Funcionalidades

### 📌 Pessoa
- Criar uma nova pessoa **com um ou mais endereços**
- Listar todas as pessoas com seus endereços
- Buscar pessoa por ID
- Atualizar cadastro de uma pessoa
- Excluir pessoa e todos seus endereços
- Calcular e retornar a **idade** de uma pessoa
- **Validação de CPF único** com exceção personalizada

### 📌 Endereço
- CRUD completo de endereços
- Endereços vinculados automaticamente ao ID de uma pessoa

---
## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- Spring Web
- Spring Data JPA
- Banco de dados **H2**
- Lombok
- Jakarta Validation
- Maven

---

## 🗄 Banco de Dados H2

Acesse o console H2 em:

> http://localhost:8080/h2-console

Use as seguintes configurações:

JDBC URL: jdbc:h2:mem:crud
User: sa
Password: (em branco)

---


---

## 🚀 Executar o Projeto

### Via Maven

```bash
mvn spring-boot:run
````

Ou via IDE

Execute a classe:

CrudPessoaApplication.java

---

## 📡 Endpoints da API:

🧍 Pessoa
➤ Criar nova pessoa:

```http request
POST /pessoas
````

Exemplo JSON:

```json
{
  "nome": "Maria Silva",
  "cpf": "12345678900",
  "dataNascimento": "1998-05-10",
  "enderecos": [
    {
      "rua": "Rua A",
      "numero": "100",
      "bairro": "Centro",
      "cidade": "Porto Alegre",
      "estado": "RS",
      "cep": "90000000"
    }
  ]
}
```

➤ Listar todas as pessoas:

```http request
GET /pessoas
````

➤ Buscar pessoa por ID:

```http request
GET /pessoas/{id}
````

➤ Atualizar pessoa:
````http request
PUT /pessoas/{id}
````

➤ Excluir pessoa:
```http request
DELETE /pessoas/{id}
````

➤ Calcular idade:
```http request
GET /pessoas/{id}/idade
````

## 🏘 Endereços

➤ Criar endereço vinculado a uma pessoa:
```http request
POST /enderecos/{idPessoa}
````

➤ Listar endereços:
```http request
GET /enderecos
````

➤ Buscar endereço por ID:
```http request
GET /enderecos/{id}
````

➤ Atualizar endereço por ID:
```http request
PUT /enderecos/{id}
````

➤ Excluir endereço:
```http request
DELETE /enderecos/{id}
```

## ⚠ Exceções Personalizadas

O projeto usa tratamento de erro profissional com exceptions próprias:

CpfDuplicadoException

PessoaNaoEncontradaException

EnderecoNaoEncontradoException



📜 Licença

Projeto educacional. Livre para estudo, uso e refatorações.