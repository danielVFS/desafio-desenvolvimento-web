<h1 align="center">
    Quiz Game
</h1>

<h3 align="center">
  Teste para Desenvolvimento Web.
</h3>

<p align="center">
  <a href="#rocket-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-instalação">Instalação</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-como-contribuir">Como contribuir</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

<br>

## :rocket: Tecnologias e Ferramentas Utilizadas

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [React](https://pt-br.reactjs.org/)
- [H2 database](https://www.h2database.com/html/main.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

- [Spring Tools](https://spring.io/tools)
- [Insomnia](https://insomnia.rest/download/)

## 💻 Projeto

Quiz game - Um quiz desenvolvido com React/Typescript com Spring boot.

<h4 align="center">
  💻 Frontend - Demo
  <br>
  <img alt="Frontend" src="https://user-images.githubusercontent.com/54604875/110020858-d31c7500-7d08-11eb-81c1-bf05c2643217.gif">
</h4>

<h4 align="center">
  💻 Requisição GET - Backend
  <br>
  <img alt="backend" src="https://user-images.githubusercontent.com/54604875/110020932-e6c7db80-7d08-11eb-8a73-070e3f381693.png">
</h4>

<br>

## 💻 Instalação

Para iniciar o **Backend** com o Spring boot certifique-se de ter instalado:

- [JDK 11](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.2+ (preferencialmente a versão 3.6.3)](https://maven.apache.org/download.cgi)

```bash
cd backend

execute:

Mac/Linux: ./mvnw spring-boot:run
Windows: mvnw spring-boot:run

Exemplo de requisição: `http://localhost:8080/questions?category=desenvolvimento%20web&amount=5`
```

Ou se preferir, importe o código diretamente em sua IDE para simplificar.

- [Spring Tools](https://spring.io/tools)
- [Eclipse](https://www.eclipse.org/downloads/)

E execute o projeto pela própria IDE.

<br>

Para iniciar o **Frontend** em React certifique-se de ter instalado:

- [Node.JS LTS](https://nodejs.org/en/)

Verifique se o Node e o NPM foram instalados corretamente.

```bash
node --version
npm --version
```

```bash
cd frontend
npm install - para baixar todas dependências do projeto.
npm start
```

Assim que o processo terminar, automaticamente será aberta no seu navegador a página `localhost:3000` contendo o projeto.

## 🤔 Como contribuir

- Faça um fork desse repositório;
- Cria uma branch com a sua feature: `git checkout -b minha-feature`;
- Faça commit das suas alterações: `git commit -m 'feat: Minha nova feature'`;
- Faça push para a sua branch: `git push origin minha-feature`.

Depois que o merge da sua pull request for feito, você pode deletar a sua branch.

---

Feito por [Daniel Vitor](https://github.com/danielVFS)
