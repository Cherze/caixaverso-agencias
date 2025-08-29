# Agencias - Projeto Grupo 3

Feito por:

  Cherze Carvalho Freitas
  
  Fabio Monteiro Crispim
  
  Marcos Guilherme Grandi
  
  Raphael dos Santos Pinto
    

## Descrição

API REST utilizando o framework Quarkus que permite o cadastro e manutenção de registros em uma base de dados, implementando as operações básicas de um CRUD completo.

> ENTITY escolhida: Agências CAIXA. 

Persistência em banco de dados H2.

Opcionais:
  - 🔄 Consumo da API pública externa VIACEP
  - ✨ Funcionalidade extra como filtro por categoria (agências por cidade ou UF) e exportação para excel.
  - 🔐 Autenticação básica (Basic Auth)
  - 📃 Integração com **Swagger/OpenAPI** para documentação
  - 💻 Frontend

## Rodando a aplicação

Disponível no endereço <http://localhost:8080/agencias>.
	- Busca por CGC da agência </cgc>
 	- Filtro por estado </filtro/estado/>
  	- Filtro por cidade </filtro/cidade/>
   	- Exportar para excel </export/excel>

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

{
	"nome_agencia" : "Feira",
	"nome_gestor" : "Cherze",
	"cgc" : "0068",
	"numero" : "250",
	"data_inauguracao" : "1925-02-17",
	"cep" : "44022072"
}



