# AULA 1

- ORM (Object relational mapping), técnica utilizada para elaborar tabelas do banco de dados através das classes
e objetos definidos na linguagem de programação, fazendo um mapeamento dos seus atributos. Nesse caso utilizamos
o Jakarta Persistence para fazer mapeamento da tabela Game através da classe Game e seus atributos.
- JPA define o padrão do ORM, ou seja, como ele deve ser implementado no Java
	- Hibernate, EclipseLink, Toplink, OpenJPA são implementações do padrão JPA
	- JPA é uma especificação e ORM é a ferramenta (Hibernate, Entity, etc)
- Padrão de Camadas
	- Front-end(App): Conversa com o Back-end através de requisições HTTP/REST, com o retorno em JSON
	- Back-end
		- Controlador(REST): Conversa com a Transação através do DTO
		- Transação
			- Camada de serviço: Conversa com a Camada de acesso a Dados através das Entities/ORM
			- Camada de acesso a dados: O repository, ele que faz a consulta no banco, traz os Games e devolve
			isso para uma classe de service e esse serviço devolve o DTO equivalente para o controlador.
			
- Quando queremos acessar os dados do banco de dados nem sempre vamos querer todas as propriedades de uma tabela
Por isso, nós precisamos criar um classe auxiliar para projetar os dados que vão ser requisitos, e que vai
ser chamada de `DTO` Data Transfer Object.
- Nesse exemplo vamos criar a classe GameMinDTO, que irá conter apenas as informações mínimas que serão 
requisitadas pela API. Após a definição de suas propriedades vamos criar um construtor que vai receber
uma entidade game e pegar os dados dela para atribuir no GameMinDTO.

- Vamos criar agora a interface GameRepository, que é a camada de acesso aos dados. 
- Cada entidade, quando vai ter seus dados alterados deve ter uma interface criada para ele, como por 
exemplo: ClienteRepository, UserRepository
	- Cria-se três arquivos GameController, GameService e GameRepository
	- GameRepository: Possui o acesso ao banco de dados.
	- GameService: Responsável por implementar a lógica de negócio, que nada mais é do que uma regra que tem que
	acontecer
		- Exemplo: Sistema de comércio, ele precisa registrar um pedido, e nesse registro é necessário, 
		verificar o estoque, dar baixa no estoque, enviar email avisando, processar cartão de crédito. Toda 
		essa regra de negócio complexa é gerada com o registro de um pedido. Essa regra de negócio fica na camada
		de serviço. 
		- Esse Service é um intermediário entre o Repository e o Controller.
		- O service tem o componente repository injetado
		- Quando acessamos o repository injetado, através do ORM ele possui diversos métodos herdados que manipulam 
		a tabela do banco de dados
	- GameController: Porta de entrada do back-end, se comunica através do Service, que retorna um DTO para ele.
		- É esse componente que expõe o Back-end para o Front-end, e que define os endpoints
		- Vamos definir os recursos do nosso back-end

- Podemos criar uma lista equivalente para transformar o Game para GameMinDTO.
