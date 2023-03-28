## Adopet (CB6 - Alura)

O projeto é o produto do sexto desafio backend, promovido pela Alura

## Tecnologias
* Conceitos de Docker (usando docker-compose para criar infra de banco de dados com MySQL e Adminer)
* SpringBoot 3
* Conceitos de REST API
* Design Patterns
* Melhores práticas de codigo usando Java

### Rodando Localmente
Para o projeto subir localmente, é necessário ter algumas ferramentas:
* Docker engine instalada (para fazer o download das imagens e subir os conteires baseados no script *docker-compose* na raiz do projeto);
* Client REST (Rest Client, Insomnia, Postman ou outro);
* Maven configurado;

Uma vez o Docker configurado, rodar no prompt ou terminal:
```docker-composer up -d```

As imagens serão baixadas e ficarão rodando em modo detached.
O MySQL estará rodando na porta padrão **3306** e o Adminer na **8081**.

Após isso rode o comando para obter as dependencias do projeto: ```mvn clean install```.
Dando tudo certo e você estando na raiz do projeto, rode o comando para iniciar a aplicação: ```mvn spring-boot:run```

A aplicação está disponível na URL: http://localhost:8082 

Pronto. Configuração concluída !