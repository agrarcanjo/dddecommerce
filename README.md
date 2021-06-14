
<h1 align="center">
    E-Commerce DDD example
</h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=15C3D6&labelColor=000000" alt="PRs welcome!" />

  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=15C3D6&labelColor=000000">
</p>

<br>

## 💻  Tecnologias

Para executar esse projeto, será necessário as tecnologias: 

- [Java 1.8](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Maven](https://maven.apache.org/download.cgi)
- [Axon Server](https://axoniq.io/download)
- [MySql](https://www.mysql.com/downloads/)
- [Xampp (facilitar Tomcat e Mysql)](https://www.apachefriends.org/pt_br/index.html)

## 💻  Projeto

#### Passo 1
Configurar o MySql com o usuário root e senha vazia como o padrão

#### Passo 2
Inicie o servidor Axon Server com o comando:

```bash
> java -jar axonserver.java
```

#### Passo 3
A aplicação já estará pronta para consumir os serviços de escalonamento e requisições, podemdo assim
iniciar a aplicação springboot DddecommerceApplication

#### Passo 4
A aplicação poderá ser acessada pelo Swagger pelo link:
[localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Conteiner Docker

Caso queira ser instanciado em um conteiner Docker, execute:

```
script de shell docker run -d -p 8024: 8024 -p 8124: 8124 -p 8224: 8224 --name axonserver axoniq / axonserver
```

##TODO
Algumas implementações ainda não foram contempladas:
 - Separar Aggregate (Order, Customer, Product) em microserviços
 - Criar Aggregate de Product
 - Criar testes unitários para os serviços
 - Melhorar serviços em Query e Controller 

 ## Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

---

by agrarcanjo 