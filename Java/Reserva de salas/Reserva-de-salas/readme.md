```markdown
# 📌 Sistema de Reserva de Salas

Sistema simples de gerenciamento de reservas de salas desenvolvido em **Java puro** (sem frameworks).  
Ideal para estudo e prática de **Programação Orientada a Objetos**, estruturas de dados, CRUD e validação de regras de negócio.

Projeto criado como exercício dentro do repositório [**java-course-repository**](https://github.com/kalebzaki4/java-course-repository).

## ✨ Funcionalidades

- Cadastro e listagem de **salas**
- Cadastro e listagem de **usuários**
- **Reserva** de salas com validação de conflitos de horário
- Listagem de todas as reservas
- **Edição** e **cancelamento** (remoção) de reservas
- Interface 100% via **terminal** (menu interativo)

## 🏗️ Estrutura do projeto

```
Reserva-de-salas/
├── src/
│   ├── model/         # Entidades: Sala, Usuario, Reserva
│   ├── service/       # Regras de negócio e controle de reservas
│   ├── util/          # Helpers (validações, formatação, scanner utilitário...)
│   └── Main.java      # Ponto de entrada e menu principal
├── .gitignore
└── README.md
```

## ⚡ Pré-requisitos

- **Java 8+** (recomendado Java 11 ou 17 LTS)
- Editor/IDE com suporte a Java  
  (IntelliJ IDEA Community, Eclipse, VS Code + Extension Pack for Java)

## ▶️ Como rodar o projeto

### 1. Via IDE (recomendado)

```bash
# 1. Clone o repositório principal
git clone https://github.com/kalebzaki4/java-course-repository.git

# 2. Abra o projeto na IDE
# 3. Localize a pasta:
#    java-course-repository/Java/Reserva-de-salas/Reserva-de-salas

# 4. Execute a classe Main.java (botão Run ou clique direito → Run 'Main.main()')
```

### 2. Via terminal (compilação manual)

```bash
# Entre na pasta do projeto
cd Reserva-de-salas

# Compile todos os arquivos .java
javac -d bin src/**/*.java

# Execute o programa
java -cp bin Main
```

## 👀 Visual do menu principal (exemplo)

```
═══════════════════════════════════════════════
          SISTEMA DE RESERVA DE SALAS
═══════════════════════════════════════════════

1) Cadastrar nova sala
2) Listar todas as salas
3) Cadastrar usuário
4) Fazer reserva
5) Listar reservas
6) Editar reserva
7) Cancelar reserva
8) Sair

Digite sua opção → 
```

## ✅ Regras de negócio implementadas

- Uma sala não pode ter duas reservas no **mesmo horário**
- Validação de existência de sala e usuário antes de reservar
- Horários são tratados como **String** no formato HH:mm (simples e didático)

## 🤝 Como contribuir

1. Faça **fork** do repositório
2. Crie uma **branch**  
   ```bash
   git checkout -b feature/nome-da-sua-melhoria
   ```
3. Commit suas alterações  
   ```bash
   git commit -m 'feat: adiciona cancelamento em lote'
   ```
4. Push para a branch  
   ```bash
   git push origin feature/nome-da-sua-melhoria
   ```
5. Abra um **Pull Request**

Toda ajuda é muito bem-vinda! 😄

## 📄 Licença

MIT License  
Feito com fins 100% educacionais — sinta-se à vontade para estudar, copiar, modificar e usar em portfólio.

## 👨‍💻 Autor

**Kaleb Santos**  
GitHub: [@kalebzaki4](https://github.com/kalebzaki4)

Feito com ☕ e muita vontade de aprender Java!
