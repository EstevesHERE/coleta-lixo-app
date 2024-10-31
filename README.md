# Spring Boot Project

Este repositório contém um projeto básico utilizando o **Spring Boot**, que é uma ferramenta poderosa para criar aplicações Java baseadas no framework Spring de maneira mais simples e com configuração mínima.

---

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas:

- **JDK 17+**: [Baixar aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **IntelliJ IDEA**: [Baixar aqui](https://www.jetbrains.com/idea/download/)
- **Maven**: A IDE já inclui o Maven, mas se você quiser instalar separadamente: [Baixar Maven](https://maven.apache.org/install.html)
- **Git**: [Clonar repositorio aqui](https://github.com/Vanessa-Bertoldo/coleta-lixo-app)
- Docker 

---

## Configuração do Ambiente

### 1. Clonar o Repositório

Primeiramente, clone o repositório para sua máquina local usando o Git:

```bash
git clone https://github.com/Vanessa-Bertoldo/coleta-lixo-app
```


---

## 2. Executando o arquivo docker

Primeiramente, pelo terminal vá até a pasta do projeto já clonado e execute o arquivo docker compose com os seguintes comandos:

```bash
  cd C:\caminho\daSuaPasta\GitHub\coleta-lixo-app
  docker-compose up
```

---

## 3. Autenticação para uso das rotas

Por meio do Postman ou insomnia, faça as requisições para as rotas:

Criação de um novo usuário:

Rota: http://localhost:8080/v1/auth/register
Corpo exemplo:

```bash
  {
    "nome": "vanessa",
    "email": "vanessa@gmail.com",
    "senha": "1234",
    "role": "ADMIN"
}
```


Rota para pegar o token que será utilizado nas outras requisições:


Rota: http://localhost:8080/v1/auth/login
Corpo exemplo:

```bash
 {
    "email": "admin@gmail.com",
    "senha": "1234"
}
```

O retorno terá um Token que será usado na key Authorization do header