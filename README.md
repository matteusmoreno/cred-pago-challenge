# Cred Pago Challenge

Este é um projeto de desafio backend da Cred Pago, desenvolvido em Java utilizando o framework Spring Boot.

## Funcionalidades

O sistema possui as seguintes funcionalidades:

- **Gerenciamento de Clientes**: Criação e armazenamento de informações sobre os clientes, incluindo dados de cartões de crédito.
- **Gerenciamento de Produtos**: Adição e listagem de produtos disponíveis.
- **Carrinho de Compras**: Adição de produtos ao carrinho de compras associado a um cliente.
- **Transações**: Processamento de transações que envolvem a compra de produtos usando os dados do cartão de crédito.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- JPA/Hibernate
- Jakarta Validation
- Banco de Dados (MySQL)
- Maven para gerenciamento de dependências

## Estrutura do Projeto

A estrutura do projeto é organizada em pacotes da seguinte forma:

- **request**: Contém classes de requisição que representam os dados enviados pelo cliente.
- **response**: Contém classes de resposta que representam os dados enviados ao cliente.
- **entity**: Contém as entidades do sistema que representam as tabelas do banco de dados.
- **repository**: Contém as interfaces que estendem JpaRepository para acesso ao banco de dados.
- **service**: Contém as classes de serviço que implementam a lógica de negócios.
- **controller**: Contém as classes que definem os endpoints da API.

## Configuração do Banco de Dados

As tabelas do banco de dados são criadas automaticamente pelo Hibernate na inicialização da aplicação. As configurações podem ser ajustadas no arquivo `application.properties`, onde você pode definir o tipo de banco de dados e as credenciais.

## Execução da Aplicação

Para executar a aplicação, siga os passos abaixo:

1. Clone o repositório:
    - git clone <URL do repositório>

2. Navegue até o diretório do projeto:
    - cd credpago_challenge

3. Compile e execute a aplicação usando Maven:
    - mvn clean spring-boot:run

## Testes

Os testes podem ser realizados usando o Postman ou qualquer outro cliente de API. A documentação dos endpoints pode ser fornecida em breve.

## Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver uma ideia para uma melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes. 
