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
  <img alt="Frontend" src="https://user-images.githubusercontent.com/54604875/109860378-d5b19880-7c3c-11eb-81b0-097c2cc0a075.gif">
</h4>

<h4 align="center">
  💻 Requisição GET - Backend
  <br>
  <img alt="backend" src="https://user-images.githubusercontent.com/54604875/109860866-6b4d2800-7c3d-11eb-8415-02beaa280f48.png">
</h4>

<br>

## 💻 Instalação

Para iniciar o **Backend** com o Spring boot certifique-se de ter instalado:

- [JDK 11](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.2+ (preferencialmente a versão 3.6.3)](https://maven.apache.org/download.cgi)

```bash
cd backend
./mvnw spring-boot:run

Exemplo de requisição: `http://localhost:8080/questions?difficulty=hard&amount=4`
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
