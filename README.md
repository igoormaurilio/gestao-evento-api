# 🎟️ API - Sistema de Gestão de Eventos

Este é um sistema simples de gerenciamento de eventos, com a funcionalidade CRUD, que permite criar eventos, listar, atualizar e excluir

## ✅ Funcionalidade Miníma

### 🎯 Funcionalidade CRUD em prática no nosso projeto.
- Criar eventos 
- Listar eventos disponíveis
- Atualizar eventos disponíveis 
- Excluir eventos

### 📅 Eventos
- Criar evento com os campos: `nome`, `descrição`, `data`, `local`, `vagas`  
- Listar eventos disponíveis  
- Atualizar dados do evento  
- Excluir evento  

### 👥 Participantes
- Cadastro de participante com: `nome`, `e-mail`, `telefone`  
- Inscrição em evento (com verificação de limite de vagas)  
- Cancelamento de inscrição  
- Listar participantes de um evento

### 🔗 Relacionamentos
- Um **evento** pode ter vários **participantes** 
- Um **participante** pode se inscrever em vários **eventos** 

---
## 4️⃣👨‍💻 Equipe e sua Divisão de Tarefas

### 👤 [Julio Cesar](https://github.com/nyxpdb)
- Configuração do projeto  
- Criação das entidades: `Evento` e `Participante`  
- Relacionamentos (ManyToMany ou com tabela intermediária)

### 👤 [Ana Karine](https://github.com/anakarine1511)
- Repository, DTO e Service das entidades  
- Lógica de inscrição com verificação de vagas

### 👤 [Ricardo Ongari](https://github.com/ricardoongari)
- Criação dos Controllers e endpoints  
- Testes com Postman

### 👤 [Igor Maurilio](https://github.com/igoormaurilio)
- Organização do repositório GitHub  
- Criação do `README.md` com instruções  
- Acompanhamento de commits e divisão de tarefas  
- Documentação com Swagger

---

# 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- REST API
- Swagger (OpenAPI)
- Postman
- Git & GitHub
- Eclipse IDE
- MySQL

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. **Instale as dependências com Maven:**
   ```bash
   mvn install

3. **Execute a aplicação:**
  ```bash
  mvn spring-boot:run
``` 
4. **Acesse a aplicação:**
  ```bash
  http://localhost:8080
```
5. **Documentação da API (Swagger):**
  ```bash
   http://localhost:8080/swagger-ui.html
```
## 📝 Observações Finais
O projeto segue arquitetura em camadas: Controller → Service → Repository → Entity
- Utilização de DTOs para transferência segura de dados
- Endpoints documentados e testados com Postman
- Interface interativa com Swagger para explorar a API


## 🖥️ Telas de criação

A tela de criação de evento permite definir os detalhes do evento, como nome, data, local e número de vagas disponíveis.

![Criação de Evento](https://media.discordapp.net/attachments/1116570191921414205/1376896024290787368/image.png?ex=6836fdd9&is=6835ac59&hm=c75e0afecef94b96ed6c0564931ec078a7a9909e352fda5645196a9fc75c49fb&=&format=webp&quality=lossless&width=1104&height=761)

## 2. Número de Participantes Maior que o Número de Vagas

Quando o número de participantes excede o número de vagas disponíveis, o sistema exibe um alerta ou impede novas inscrições, garantindo o controle do evento.

![Participantes Excedendo Vagas](https://media.discordapp.net/attachments/1116570191921414205/1376896454202888312/image.png?ex=6836fe40&is=6835acc0&hm=99b68224469713a6c216360df772753d0213ade1173c8b9f782fea43cabdfceb&=&format=webp&quality=lossless&width=1104&height=726)

## 3. Número Correto de Participantes

Quando o número de participantes está dentro do limite de vagas, o evento segue normalmente e todos os registros são aceitos.

![Número Correto de Participantes](https://media.discordapp.net/attachments/1116570191921414205/1376896456882913461/image.png?ex=6836fe40&is=6835acc0&hm=1ebdef3236bdb988d2b198180c8f5ae3be550bd8a058d9249f81b78453e37864&=&format=webp&quality=lossless&width=1104&height=756)

## 4. Registro no Banco de Dados

O registro dos participantes é feito utilizando o **ID** de cada usuário. Isso garante unicidade e facilita a gestão dos participantes em cada evento.

![Registro no Banco](https://media.discordapp.net/attachments/1116570191921414205/1376897056781897890/image.png?ex=6836fecf&is=6835ad4f&hm=be8f1f20e6063ed815230465758c29ad88b1498fa5e298231ee93938d415ceb6&=&format=webp&quality=lossless&width=402&height=363)

---
