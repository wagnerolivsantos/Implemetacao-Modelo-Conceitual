<!-- TITULO PRINCIPAL -->
<h1 id="inicio" align="center">Implementação Modelo Conceitual</h1>

<!-- APRESENTAÇAO -->
<p align="justify">
	O projeto criado inicialmente para realizar uma implementação padrão do seguinte <b>Modelo Conceitual Uml</b>. No paradigma orientado objeto, usando padrões de mercado e boas práticas.
</p>

<!-- BOTOES STATUS -->
<p align="center">
	<a href="https://github.com/wagnerolivsantos">
		<img src="https://img.shields.io/badge/Made%20by-Wagner%20Oliveira-brightgreen">        
	</a>
	<a href="https://github.com/wagnerolivsantos/Implemetacao-Modelo-Conceitual/commits/master">
		<img src="https://img.shields.io/badge/Last%20commit-Maio-green">
	</a>
	<a href="#">
		<img src="https://img.shields.io/badge/License-MIT-brightgreen">
	</a>
</p>

<hr>

<!-- ÍNDICE -->
<h2 id="indice">📋	ÍNDICE</h2>

<p>💠 <a href="#objetivo">OBJETIVO</a></p>
<p>💠 <a href="#intalacao">INSTALAÇÃO</a></p>
<p>💠 <a href="#executandoAmbiente">EXECUTANDO O AMBIENTE DE DESENVOLVIMENTO</a></p>
<p>💠 <a href="#rotas">ROTA</a></p>
<p>💠 <a href="#errosGerais">ERROS</a></p>
<p>💠 <a href="#license">LICENÇA</a></p>
<p>💠 <a href="#contato">CONTATO</a></p>

<hr>

<!-- OBJETIVO ESPECIFICOS -->
<h2 id="objetivo">🎯	OBJETIVO</h2>

<pre>
	📌	<b>Implementar o padrão do seguinte modelo conceitual</b>

	<p align="center"><img src="/Projeto_IMG/ModeloConceitualUml.png" width="700" height="641"></p>	
	<p align="center"><img src="/Projeto_IMG/enums.png" width="700" height="152"></p>	

	📌	<b>Instância do modelo conceitual</b>

	<p align="center"><img src="/Projeto_IMG/Instancia.png" width="700" height="258"></p>	

	📌	<b>Gerar uma base de dados relacional automática e povoar a partir do modelo conceitual </b>

	📌	<b>Recuperar os dados e disponibilizá-los por meio de uma API Rest</b>

</pre>

<hr>

<!-- INSTALAÇÃO GERAL -->
<h2 id="intalacao">🛠️	INSTALAÇÃO</h2>
<h3>Requisito</h3>

<pre>
	✔️	<a href="https://git-scm.com/downloads">Git</a>
	✔️	<a href="https://github.com/">Conta no GitHub</a>
	✔️	<a href="https://www.google.com/intl/pt-BR/chrome/">Google Chrome</a>
	✔️	<a href="https://www.oracle.com/java/technologies/javase-jdk8-downloads.html">JDK - Java Development Kit</a>
	✔️	<a href="https://spring.io/tools">STS - Spring Tool Suit (Eclipse / Maven / Tomcat / Jackson / JPA)</a>
</pre>

<h3>Clone Repositório</h3>

<pre>
	<b>git clone</b> https://github.com/wagnerolivsantos/Implemetacao-Modelo-Conceitual.git
</pre>

<hr>

<!-- EXECUCAÇÃO DO AMBIENTE -->
<h2 id="executandoAmbiente">🏍️💨	EXECUTANDO AMBIENTE  DE DESENVOLVIMENTO</h2>

<h3>Spring Tool Suite</h3>

<pre>
	🔸   Utilizar a IDE <b>Spring Tool Suite</b> ou <b>Eclipse com plugin STS</b> para importar o projeto.
	🔸   Execute o projeto
	🔸   Após a execução, verificar através do console IDE se houve <b>algum erro.</b>
</pre>

<h3>Banco Dados H2</h3>

<p>Com o projeto em execução, abra seu browser para acessar a base de dados criada.</p>

<pre>
	<b>http://localhost:8080/h2-console</b>
</pre>

<p>Depois de inserir o link no browser, agora, deve ter acesso a interface do <b><i>Banco de Dados H2</i></b>.<br>
Click em <b>conectar / connect.</b></p>

<p>⚠️ <b>Em caso de erro <a href="#errosGerais">clique aqui</a>.</b></p>

<p>Após ter realizado o login no Banco de Dados, iremos <b>executar uma query</b> retornando todos pedidos realizados pela <b>Maria Silva.</b> copie e cole o código abaixo na <b>área Comando Sql</b>, assim, efetue execução do comando.</p>

```sql
SELECT
	C.NOME,
	C.CPF_OU_CNPJ,
	P.INSTANTE,
	E.LOGRADOURO,
	E.NUMERO,
	E.COMPLEMENTO
FROM PEDIDO P
INNER JOIN ENDERECO E
ON E.ID = P.ID_ENDERECO_ENTREGA
INNER JOIN CLIENTE C
ON C.ID = P.ID_CLIENTE
WHERE C.NOME = 'Maria Silva';
```

<h4>Resultado:</h4>

| NOME | CPF_OU_CNPJ | INSTANTE | LOGRADOURO | NUMERO | COMPLEMENTO |  
| ---- | ----------- | -------- | ---------- | ------ | ----------- |
| Maria Silva | 36378912377 | 2017-09-30 10:32:00 |	Rua Flores | 300 | Apto 203 |
| Maria Silva | 36378912377 | 2017-10-10 19:35:00 |	Avenida Matos | 105 | sala 800 |

<p>Ambiente esta configurado e funcionando corretamente.</p>

<hr>

<!-- ROTAS -->
<h2 id="rotas">🚊	Rotas</h2>

<p>O URL base: http://localhost:8080/api/v1/<b>endPoint</b>/<b>id</b></p>

<h3>Exemplo</h3>
<p>Essa rota retorna um <b><i>Json</i></b> contendo os <code>produtos</code> que estão relacionado aquela <code>categoria</code>. Juntamente com categoria o número <code>id</code> é passado por parâmetro para selecionar o produto específico.</p>

| EndPoint | Método | Parâmetro | Resposta |
| -------- | ------ | --------- | -------- |
| /categorias | GET | 1 | {"id":1,"nome":"Informática","produtos":[{"id":1,"nome":"Computador","preco":2000.0},{"id":2,"nome":"Impressora","preco":800.0},{"id":3,"nome":"Mouse","preco":80.0}]} |

<pre>
	<code>http://localhost:8080/api/v1/categorias/1</code>
</pre>	

<h4>Resultado:</h4>

```json
{
  "id": 1,
  "nome": "Informática",
  "produtos": [
      {
          "id": 1,
          "nome": "Computador",
          "preco": 2000
      },
      {
          "id": 2,
          "nome": "Impressora",
          "preco": 800
      },
      {
          "id": 3,
          "nome": "Mouse",
          "preco": 80
      }
  ]
}
```

<hr>

<!-- ERROS GERAIS -->
<h2 id="errosGerais">⚠️	ERROS</h2>

<h3>Acesso ao Banco de Dados:</h4>

<p>verifique os campos da interface, se estão corretamente preenchidos.</p>

| Configuração ativa | Nome da configuração | Classe com o driver | JDBC URL | Usuário |
| ------------------ | -------------------- | ------------------- | -------- | ------- |
| Generic H2 (Embedded) | Generic H2 (Embedded) | org.h2.Driver | jdbc:h2:mem:testdb | sa |

<hr>

<!-- LICENÇA -->
<h2 id="license">💡	LICENÇA</h2>

<p>Este projeto está licenciado sob a licença MIT - consulte o arquivo <a href="#">LICENSE.md</a> para obter detalhes</p></p>

<hr>

<h2 id ="contato">✉️ CONTATO</h2>

<p><b>Contato:</b> wagnerolivsantos@outlook.com</p>

<hr>
	
<p align="right"><a href="#inicio">🆙</a></p></p>
