# Assembleia-Cooprativa

Este projeto consiste em um sistema de votação no qual associados votam em uma pauta com "SIM" ou "NAO", quando a sessão de votos é encerrada o sistema informa se a pauta foi aprovada ou recusada.

O sistema possui as seguintes funcionalidades:

* Cadastrar uma nova pauta;
* Abrir uma sessão de votação em uma pauta (a sessão de votação fica aberta por um tempo
determinado na chamada de abertura ou 1 minuto por default);
* Receber votos dos associados em pautas (os votos são apenas 'SIM'/'NAO'. Cada associado pode votar apenas uma vez por pauta);
* Contabilizar os votos e dar o resultado da votação na pauta.

Para realizar a consistência dos dados foi usado o banco de dados MySQL, as configurações usadas então no arquivo  
`src/main/resources/application.properties`.
Para configurar os parâmetros de conexão do seu banco de dados é necessário alterar os parâmetros desse arquivo.

Para cadastrar um novo associado no sistema é necessário enviar uma requisição do tipo POST para a URL:  
`http://localhost:8080/associado`. 
O corpo da requisição deve conter um JSON com a variável "nome", referente ao nome do associado, como por exemplo:  
`{
  "nome" : "Gabriel"
 }`  
 
 Para cadastrar uma nova pauta no sistema é necessário enviar uma requisição do tipo POST para a URL:  
`http://localhost:8080/pauta`. 
O corpo da requisição deve conter um JSON com a variável "descricao", referente à descrição da pauta, como por exemplo:  
`{ 
  "descricao" : "Pauta Teste"
 }`  
 
  Para cadastrar uma nova sessão de votação no sistema é necessário enviar uma requisição do tipo POST para a URL:  
`http://localhost:8080/sessao`. 
O corpo da requisição deve conter um JSON com a variável "descricaoPauta", que será a pauta associada à nova sessao 
(deve ser enviado o nome de uma pauta existente no sistema) e a variável "tempoDuracao", que é o tempo que a sessão de votação ficará aberta, 
essa variável é opcional, se não for enviado nada o tempo padrão da votação é de 1 minuto.
Exemplo de JSON:  
`{
    "tempoDuracao" : "60",
    "descricaoPauta" : "Pauta Teste"
}` 
 
  Para cadastrar um voto no sistema é necessário enviar uma requisição do tipo POST para a URL:  
`http://localhost:8080/voto`. O corpo da requisição deve conter 3 parâmetros. "statusVoto", deve ser "SIM" ou "NAO", "NomeAssociado", o nome do 
associado que está votando (deve ser o nome de um associado cadastrado no sistema) e "descricaoPauta", a pauta na qual o voto será registrado
(a pauta deve estar cadastrada no sistema e deve existir uma sessão de votos associada a ela). Exemplo de JSON:  
`{
    "statusVoto" : "NAO",
    "nomeAssociado" : "Gabriel",
    "descricaoPauta": "Pauta Teste"
}`


Para consultar informações sobre uma pauta é necessário enviar uma requisição do tipo GET para URL:  
`http://localhost:8080/pauta/{descricaoPauta}`, onde "descricaoPauta" é a descrição da pauta consultada.
 
