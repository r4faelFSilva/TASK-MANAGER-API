# Task Manager API

Sistema de gerenciamento de tarefas com autenticação JWT desenvolvido com Spring Boot.

## 📋 Sobre o Projeto

Este é um projeto acadêmico que implementa uma API REST para gerenciamento de tarefas pessoais. Cada usuário pode criar, visualizar, atualizar e excluir suas próprias tarefas, com autenticação segura via JWT.

## 🚀 Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 3.2.5**
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **JWT (JSON Web Token)** - Tokens de autenticação
- **H2 Database** - Banco de dados em memória
- **Swagger/OpenAPI** - Documentação da API
- **Maven** - Gerenciamento de dependências

## 📁 Estrutura do Projeto

```
src/main/java/com/taskmanager/
├── config/
│   ├── GlobalExceptionHandler.java
│   ├── SecurityConfig.java
│   └── SwaggerConfig.java
├── controller/
│   ├── AuthController.java
│   └── TaskController.java
├── dto/
│   ├── AuthResponse.java
│   ├── LoginRequest.java
│   ├── RegisterRequest.java
│   ├── TaskRequest.java
│   └── TaskResponse.java
├── model/
│   ├── Task.java
│   ├── TaskStatus.java
│   └── User.java
├── repository/
│   ├── TaskRepository.java
│   └── UserRepository.java
├── security/
│   ├── JwtAuthenticationFilter.java
│   └── JwtService.java
├── service/
│   ├── AuthService.java
│   └── TaskService.java
└── TaskManagerApplication.java
```

## 🛠️ Como Executar

### Pré-requisitos

- Java 25+
- Maven 3.6+

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/task-manager-api.git
cd task-manager-api
```

2. Execute o projeto:
```bash
mvn spring-boot:run
```

3. Acesse:
   - **API**: http://localhost:8080
   - **Swagger UI**: http://localhost:8080/swagger-ui.html
   - **Console H2**: http://localhost:8080/h2-console

### Configuração do Console H2

- **JDBC URL**: `jdbc:h2:mem:taskdb`
- **Username**: `sa`
- **Password**: *(vazio)*

## 📚 Endpoints da API

### Autenticação

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/auth/register` | Registrar novo usuário |
| POST | `/auth/login` | Fazer login e obter token |

### Tarefas (requer autenticação)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/tasks` | Criar nova tarefa |
| GET | `/tasks` | Listar todas as tarefas |
| GET | `/tasks/{id}` | Buscar tarefa por ID |
| PUT | `/tasks/{id}` | Atualizar tarefa |
| DELETE | `/tasks/{id}` | Excluir tarefa |

## 🔐 Autenticação

Para acessar os endpoints de tarefas, é necessário incluir o token JWT no header:

```
Authorization: Bearer {seu_token_jwt}
```

### Exemplo de Uso

1. **Registrar usuário:**
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@email.com",
    "password": "senha123"
  }'
```

2. **Fazer login:**
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "joao@email.com",
    "password": "senha123"
  }'
```

3. **Criar tarefa:**
```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer {token}" \
  -d '{
    "title": "Estudar Spring Boot",
    "description": "Revisar conceitos de Spring Security",
    "status": "PENDING"
  }'
```

## 📊 Modelo de Dados

### User
| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | ID único |
| name | String | Nome do usuário |
| email | String | Email (único) |
| password | String | Senha criptografada |

### Task
| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | ID único |
| title | String | Título da tarefa |
| description | String | Descrição |
| status | Enum | PENDING, IN_PROGRESS, COMPLETED |
| createdAt | DateTime | Data de criação |
| updatedAt | DateTime | Data de atualização |
| userId | Long | ID do usuário dono |

## ✅ Requisitos Funcionais

- [x] RF01 – Registrar usuário
- [x] RF02 – Fazer login e gerar token
- [x] RF03 – Criar tarefa
- [x] RF04 – Listar tarefas do usuário
- [x] RF05 – Atualizar tarefa
- [x] RF06 – Excluir tarefa

## 📝 Requisitos Não Funcionais

- [x] RNF01 – Usar Spring Boot
- [x] RNF02 – Usar JWT
- [x] RNF03 – Usar banco H2
- [x] RNF04 – API REST
- [x] RNF05 – Documentação Swagger

## 👥 Equipe

- Desenvolvedor - Rafael Francisco da Silva

## 📄 Licença

Este projeto está sob a licença MIT.
