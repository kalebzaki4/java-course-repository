# 📌 Sistema de Reserva de Salas (Java)

Um sistema desenvolvido em **Java puro** para gerenciar reservas de salas — ideal para fins de aprendizado, prática de POO (Programação Orientada a Objetos) e organização de agendas de espaços.  
Este projeto faz parte do repositório **java-course-repository** e foi criado para consolidar conceitos de lógica, estrutura de dados, CRUD e interação via terminal.

---

## 🚀 Descrição

O **Sistema de Reserva de Salas** permite que o usuário:

✔ Cadastre salas e usuários  
✔ Visualize salas disponíveis  
✔ Realize reservas de salas em horários específicos  
✔ Liste, edite e remova reservas existentes  

Ele funciona via **interface de terminal/console**, seguindo fluxo de menus simples e intuitivos para operações básicas de reserva.

---

## 🛠️ Funcionalidades Principais

- 📌 Cadastro de sala  
- 👤 Cadastro de usuário  
- 📆 Registro de reservas com validação de disponibilidade  
- 📋 Visualização de reservas  
- ✏️ Atualização de registros  
- ❌ Remoção de reservas  
- 🧠 Validação de regras de negócio (ex: não permitir conflito de horários)

---

## 🧱 Estrutura do Projeto


Reserva-de-salas/
├── src/                 # Código-fonte principal
│   ├── model/           # Modelos de dados (Sala, Reserva, etc.)
│   ├── service/         # Lógica de negócio
│   ├── util/            # Utilitários
│   └── Main.java        # Entrada do programa
├── .gitignore
└── README.md            # Este arquivo

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

✔ **Java JDK 8 ou superior** instalado  
✔ Um editor ou IDE (ex: **IntelliJ IDEA** ou **VS Code**) configurado para Java  

---

## ▶️ Como Executar

### Usando IDE
1. Clone o repositório:
2. 
   git clone https://github.com/kalebzaki4/java-course-repository.git


2. Abra o projeto na sua IDE favorita.
3. Navegue até o diretório:

   Java/Reserva de salas/Reserva-de-salas
4. Execute a classe `Main.java`.

---

### Via Terminal

Dentro da pasta do projeto:

```bash
javac -d out src/*.java
java -cp out Main
```

O sistema será iniciado exibindo um **menu interativo no terminal**.

---

## 💡 Exemplo de Uso

Ao iniciar o sistema:

```
=== Menu Principal ===
1) Cadastrar sala
2) Listar salas
3) Reservar sala
4) Listar reservas
5) Sair
```

O usuário escolhe a opção desejada e segue as instruções exibidas no console.

## 🚧 Melhorias Futuras

* Persistência de dados em arquivo ou banco de dados
* Interface gráfica (Swing ou JavaFX)
* Autenticação de usuários
* Testes automatizados
* Organização mais avançada por camadas (MVC)

---

## 🤝 Contribuindo

1. Faça um **fork** do projeto
2. Crie uma **branch** para sua feature
3. Commit suas alterações
4. Abra um **Pull Request**

Toda contribuição é bem-vinda! 🚀

---

## 📝 Licença

Projeto open-source para fins educacionais.
Sinta-se livre para usar, modificar e estudar o código.

---

## 👤 Autor

**Kaleb Santos**
GitHub: [https://github.com/kalebzaki4](https://github.com/kalebzaki4)
