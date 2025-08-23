# Agencias - Projeto Grupo 3

Feito por:

  Cherze Carvalho Freitas

  Raphael dos Santos Pinto
  
  Fabio Monteiro Crispim
  
  Marcos Guilherme Grandi

## Descrição

API REST utilizando o framework Quarkus que permite o cadastro e manutenção de registros em uma base de dados, implementando as operações básicas de um CRUD completo.
Persistência em banco de dados H2.

Obcionais:
  - 🔄 Consumo de uma **API pública externa**
  - ✨ Funcionalidade extra relacionada ao tema (ex: relatório, filtro por categoria, exportação, etc)
  - 🔐 Autenticação básica (Basic Auth)
  - 📃 Integração com **Swagger/OpenAPI** para documentação
  - 💻 Frontend

> ENTITY escolhida: Agências CAIXA. 

## Rodando a aplicação

Disponível no endereço <http://localhost:8080/agencias>.

un Hilla React applications on Quarkus.
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Quarkus - OpenAPI Generator - Server ([guide](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/index.html)): Generates REST servers based on OpenAPI specification files
- REST resources for Hibernate Reactive with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate Jakarta REST resources for your Hibernate Reactive Panache entities and repositories
