# Desafio primeiro checkpoint Alura (API RESTful)

Este projeto é uma API RESTful para gerenciar reservas de salas, 
com algumas regras de negócio, como por exemplo: 
 validação de datas, capacidade e conflitos de horários, 
sejam respeitadas. 
Foi desenvolvido usando o Spring Boot e a arquitetura JPA/Hibernate.

##  Tecnologias e Arquitetura

* *Linguagem:** Java 17+
* *Framework:** Spring Boot 3
* *Persistência:** Spring Data JPA / Hibernate
* *Build:** Gradle
* *Auxiliar:** Lombok
* *Banco de dados:* PostegreSQL 

A arquitetura do projeto segue o padrão de camadas: `controller` (API), `business` ( ServiceReserva, SalaService, UsuarioService),  `dtos`(Dtos response e Request para Usuario, Reserva, Sala conversão de DTOS para Entidades) `infrastructure` (Entidades, Repositórios, Enums e Exceptions).

##  Configuração e Inicialização

Para rodar o projeto localmente, siga os passos abaixo:

1.  **Clone o Repositório:**
    ```bash
    git clone [https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github](https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github)
    ```
2.  **Configurar o Banco de Dados:**
    * Verifique as configurações de conexão (DataSource) no arquivo `src/main/resources/application.properties`.
3.  **Build do Projeto:**
    * Execute o comando Gradle para compilar e gerar o pacote:
    ```bash
    ./gradlew clean build
    ```
4.  **Iniciar a Aplicação:**
    * Inicie o servidor a partir do terminal (ou diretamente da sua IDE, como o IntelliJ):
    ```bash
    ./gradlew bootRun
    ```

A API estará disponível em `http://localhost:8080`.

##  Funcionalidades e Endpoints

O projeto gerencia a criação de reservas, realizando validações críticas de negócio antes da persistência.

### 1. Criar Reserva (POST)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/reservas` | Cria uma nova reserva, validando os IDs da sala e usuário, a capacidade e a disponibilidade de horário. |

### Validações de Negócio Implementadas

O `ServiceReserva` verifica automaticamente as seguintes regras:

1.  **Disponibilidade de Sala:** A sala não pode estar `INATIVA`.
2.  **Existência de IDs:** Valida se `SalaEntity` e `UsuarioEntity` existem no banco de dados. Caso contrário, lança `IdNaoEncontrado`.
3.  **Datas Válidas:** As datas de início e fim devem ser válidas e no futuro.
4.  **Conflito de Horário:** Verifica se não há outra reserva `ATIVA` para a mesma sala no período solicitado.
5.  **Capacidade:** A capacidade solicitada (`capacidade_pessoas` na Reserva) deve ser menor ou igual à capacidade total da sala.

---

### Exemplo de Requisição (POST /reservas)

A requisição é para envuar um objeto `ReservaRequest`,  e retornara um objeto response para visualização

**URL:** `POST http://localhost:8080/reservas`

**Corpo da Requisição (JSON):**

```json
{
  // Data inicio do evento
    "dataInicio": "2025-12-01T14:00:00", 
  // data fim do evento
    "dataFinal": "2025-12-01T16:00:00", 
  // Quantas pessoas irão ao evento
    "capacidade_pessoas": 8,
    
    // IDs das entidades existentes
    "usuarioId": 1, 
    "salaId": 2 
}
```
### Exemplo de Requisição (POST /sala)

A requisição é para enviar um objeto `SalaRequest`  e retornara um objeto response para visualização

**URL:** `POST http://localhost:8080/sala`

**Corpo da Requisição (JSON):**

```json
{
  // Capacidade 5000 pessoas
  "capacidade":5000,
  // Informando que está ativa
  "ativa":true

}
```
### Exemplo de Requisição (POST /usuario)

A requisição é para enviar um objeto `UsuarioRequest` e retornara um objeto response para visualização

**URL:** `POST http://localhost:8080/usuario`

**Corpo da Requisição (JSON):**

```json
{

// nome do usuario
  "nome":"nome do usuario",
  // cpf do usuario
  "cpf": "125.654.152.10",
  //email do usuario
  "email": "email@email.com"


}
```

### Exemplo de Requisição (Get /reservas)

A requisição é para visualizar as datas da sala pelo seu id, retornando um objeto response para visualização

**URL:** `GET http://localhost:8080/reserva?id=1`

Irá mostrar todas as salas que ja tem reserva com id 1







