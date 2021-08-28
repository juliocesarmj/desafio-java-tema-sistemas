# desafio-java-tema-sistemas
Desafio prático vaga dev java JR
**************************************
Banco de dados de teste H2
Configurações do banco e porta para acesso a API estão no arquivo src\main\resources\application.properties
Endereço da API http://localhost:8081/carta
Requisições disponíveis:
POST/PUT/DELETE/GET/GETBYID/GETBYNOME/GETBYTIPO/GETBYCLASSE
Para pesquisar por ID, se faz necessário informar o id numérico na url ex: http://localhost:8081/carta/1
Para pesquisar por NOME, se faz necessário informar o nome do personagem na url: ex http://localhost:8081/carta/nome/draven
Para pesquisar por TIPO, se faz necessário informar o tipo de poder do personagem na url: ex http://localhost:8081/carta/tipo/magia
Para pesquisar por CLASSE, se faz necessário informar a classe a qual o personagem pertence, na url: ex http://localhost:8081/carta/classe/mago
Para realizar a operação de POST se faz necessário, acessar dentro do POSTMAN, através da URL: http://localhost:8081/carta selecionar a opção POST>body>raw>Json e preencher o objeto conforme exemplo abaixo:
{
    "nome": "jax",
    "descricao": "jax dando linha na pipa",
    "ataque" : 10,
    "defesa": 7,
    "tipo": "MAGIA",
    "classe": "MAGO"
}

Para realizar a operação de PUT se faz necessário, acessar dentro do POSTMAN, através da URL: http://localhost:8081/carta selecionar a opção POST>body>raw>Json e preencher o objeto conforme exemplo abaixo:
{
    "id": 1,
    "nome": "jax",
    "descricao": "jax dando linha na pipa",
    "ataque" : 10,
    "defesa": 7,
    "tipo": "MAGIA",
    "classe": "MAGO"
}

Para realizar a operação de GET se faz necessário, acessar dentro do POSTMAN, através da URL: http://localhost:8081/carta 
Para realizar a operação de DELETE se faz necessário, informar o ID dentro do POSTMAN, através da URL: http://localhost:8081/carta/1
