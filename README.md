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

JSONs para teste:

{
	"nome_agencia" : "Francisco Porto",
	"nome_gestor" : "Bruna",
	"cgc" : "2175",
	"numero" : "100",
	"data_inauguracao" : "2002-05-10",
	"cep" : "49001108"
}

{
	"nome_agencia" : "Serigy",
	"nome_gestor" : "Amanda",
	"cgc" : "0059",
	"numero" : "150",
	"data_inauguracao" : "1952-10-25",
	"cep" : "44088714"
} 

CEP válido para teste de PUT/PATCH: 44022072




