# API para consulta de frete

Projeto desnvolvido em Java 11 com Spring Boot 2.7

Testes unitários escritos com Junit5 e automatizados com Cucumber

API simples que recebe como entrada um CEP e retorna um objeto com os detalhes do endereço e um valor pré definido de frete.

## Conteúdo

1 - [Pacote](#pacote)

2 - [Swagger](#swagger)

3 - [Instruções para build](#instruções-para-build)

4 - [Dependências](#dependências)

## Pacote

Você pode iniciar o projeto através do [pacote]() com o comando abaixo:

```
java -jar consulta-frete-1.0.0.jar
```

## Swagger

O arquivo swagger contendo a documentação dos endpoints está disponível [aqui](./swagger.yaml).

Também é possível visualizar uma interface do swagger acessando a url [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html) enquanto o projeto está sendo executado.

## Instruções para build

Dentro da pasta do projeto, basta executar os comandos:

```
mvn clean build
mvn package
```

Um arquivo .jar será gerado dentro da pasta "target".

Então basta executar o projeto:

```
java -jar target/consulta-frete-1.0.0.jar
```

## Dependências

- [Maven](https://maven.apache.org/)

- [Java jdk11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
