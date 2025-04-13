# Projeto de conclusão da disciplina de Programação 2

Professor: Ricardo de Andrade Araújo  
Autores: Eliseu Brito, Álysson Michel e Vinicius Pereira  

---

## Resumo

Este é um sistema para registro e gerenciamento de chaves, professores e reservas de sala. O projeto foi desenvolvido em Java, com uma interface gráfica simples e funcionalidades completas para cadastro, consulta, edição e exclusão de dados.

---

## Funcionalidades

- [x] Cadastrar professor, chave e reserva  
- [x] Consultar professor, chave e reserva  
- [x] Alterar dados cadastrados  
- [x] Remover itens registrados  
- [x] Listar todos os professores, chaves ou reservas  
- [x] Interface gráfica intuitiva  

### Features

- [x] Tabelas organizadas  
- [x] GUI com cores  
- [ ] Conexão com banco de dados  

---

## Requisitos

- IDE Java (IntelliJ, NetBeans ou VSCode com suporte para Java)  
- Git instalado (ou faça o download ZIP)  
- SDK Java 18 ou superior  
- Sistema compatível: Windows, Linux ou macOS

---

## Instalação

Caso não tenha o Git, siga esses passos:

1. Acesse o repositório no GitHub  
2. Clique em **Code** > **Download ZIP**  
3. Extraia os arquivos em uma pasta de sua preferência  

Para rodar o projeto:

1. Abra a pasta no IntelliJ ou sua IDE preferida  
2. Certifique-se de que o SDK Java 18 está configurado  
3. Rode a classe `app.java` dentro do pacote `gui`

---

## ☕ Estrutura do Projeto

```
RegistroChave/
│
├── .idea/                 # Configurações da IDE
├── out/                   # Saída do compilador
│
└── src/                   # Código fonte
    ├── cores/             # Classes de estilização
    ├── dados/             # Representações de chave, reserva e professor
    ├── excecao/           # Exceções
    ├── fachada/           # Fachada para unificar regras 
    ├── gui/               # Interface gráfica
    ├── negocio/           # Lógica de negócio (cadastros e regras)
    └── repositorio/       # Armazenamento em memória
```

---

## Arquitetura

O projeto segue a **Arquitetura em Camadas (Layered Architecture)**, dividindo responsabilidades para melhor manutenção do código.

---

### Camadas do Projeto

- **GUI (gui/app.java):** Interface gráfica principal com o usuário  
- **Negócio (negocio/):** Regras de cadastro, alteração e listagem  
- **Fachada (fachada/):** Camada intermediária para organizar chamadas  
- **Dados (dados/):** Estruturas que representam professores, chaves e reservas  
- **Exceções (excecao/):** Tratamento de erros específicos  
- **Repositórios (repositorio/):** Simulam o banco de dados na memória  