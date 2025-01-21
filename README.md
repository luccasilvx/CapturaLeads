# API REST para Gerenciamento de Matrículas

## Descrição
Este projeto é uma aplicação que utiliza a arquitetura MVC para gerenciar matrículas de alunos. Ele foi desenvolvido para fins de estudo e demonstração técnica..


## Funcionalidades
- [1] salvar uma matrícula
- [2] listar os matriculados
- [3] buscar uma matrícula
- [4] excluir uma matrícula

## Tecnologias Utilizadas
- Java 11+
- Spring Boot (Maven)
- MySQL
- Swagger UI
- HTML/CSS para o front-end
- Postman (opcional para testes de API)

## Instalação
1. Clone este repositório:
   ```bash
   git clone https://github.com/luccasilvx/CapturaLeads.git

## Acessos
- Para acessar a interface no navegador:
  
   [http://localhost:8081/index.html](http://localhost:8081/index.html)
  
- Para acessar a documentação dos endpoints (Swagger):
  [http://localhost:8081/swagger-ui/index.html#/](http://localhost:8081/swagger-ui/index.html#/)

## Requisições
  **Corpo da requisição (JSON):**
  
  **POST** `/matricula/salvar`
  {
  "nome": "lucas freitas",
  "email": "teste@gmail.com",
  "telefone": "11 95989-9795",
  "curso_id" 1
  }

  **GET** `/matricula/listar_matriculados`
  {}

  **GET** `/matricula/buscar_matricula/{codigo_matricula}`
  {1}

  **DELETE** `/matricula/excluir_matricula/{codigo_matricula}`
  {1}

## Contato
Lucas Freitas da Silva - lucafreitasilva@gmail.com  
LinkedIn: [Lucas Freitas da Silva](https://www.linkedin.com/in/luc4s-freit4s)
