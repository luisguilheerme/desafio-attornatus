# API de Gerenciamento de Pessoas

Uma API simples para gerenciar informações de pessoas e seus endereços.

## Funcionalidades

- [x] Criar uma pessoa
- [x] Editar uma pessoa
- [x] Consultar uma pessoa
- [x] Listar pessoas
- [x] Criar endereço para pessoa
- [x] Listar endereços da pessoa
- [x] Definir o endereço principal da pessoa

## Requisitos

- [x] Todas as respostas da API são em formato JSON
- [x] Banco de dados H2
- [x] Testes unitários
- [x] Clean Code

## Tecnologias Utilizadas

- Spring Boot
- H2 Database
- Java
- JUnit
- Swagger (para documentação da API)
- Jacoco (para cobertura de testes)

## Configuração do Ambiente

Certifique-se de ter o Java e o Maven instalados em sua máquina antes de prosseguir.

## Configuração do Banco de Dados

A aplicação está configurada para usar o banco de dados H2 em memória por padrão. Você pode ajustar as configurações do banco de dados no arquivo `application.properties`.

## Como Usar

### Construindo o Projeto

Para construir o projeto, execute o seguinte comando:

```bash
mvn clean install
```

### Executando a Aplicação

Para executar a aplicação, use o comando:

```bash
mvn spring-boot:run
```

## Documentação da API (Swagger)

Você pode acessar a documentação da API utilizando o Swagger. Após iniciar a aplicação, acesse o seguinte URL em seu navegador:

http://localhost:8080/swagger-ui.html


## Cobertura de Testes (Jacoco)

Para verificar a cobertura de testes do projeto, execute o seguinte comando:

```bash
mvn clean verify
```

Um relatório de cobertura de testes será gerado na pasta target/site/jacoco. Abra o arquivo index.html em seu navegador para visualizar os resultados.



