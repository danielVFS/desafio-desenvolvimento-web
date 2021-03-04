package com.daniel.backend.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.backend.domain.Question;
import com.daniel.backend.repositories.QuestionRepository;

@Service
public class DBService {

	@Autowired
	private QuestionRepository questionRepository;

	private Set<String> createIncorrectAnswers(String answer1, String answer2, String answer3) {
		Set<String> incorrect_answers = new HashSet<String>();
		incorrect_answers.add(answer1);
		incorrect_answers.add(answer2);
		incorrect_answers.add(answer3);

		return incorrect_answers;
	}

	public void databaseInstance() {
		/*
		 * answers of the test
		 */
		Question question1 = new Question(null, "desenvolvimento web", "easy",
				"Em javascript, qual a diferença entre Set e Map?",
				"O Set tem função parecida com o Array, porém com a diferença de armazenar apenas valores únicos, sendo possível armazenas qualquer tipo de dados. Já o Map é uma coleção de pares chave/valor inseridos na ordem de entrada.",
				this.createIncorrectAnswers("Não existe diferença.",
						"O Set é um objeto encapsulado que permite você trabalhar com valores numéricos. Já o Map tem a função de mapear uma matriz",
						"Map e Set não são conceitos do Javascript."));
		Question question2 = new Question(null, "desenvolvimento web", "hard", "O que é closure em javascript?",
				"Em resumo, Closure se trata de uma função que é capaz de \"lembrar\" do seu escopo léxico(bloco) no qual ela foi criada, podendo utilizar os dados do escopo externo.",
				this.createIncorrectAnswers(
						"É um método especial para criar e inicializar um objeto criado a partir de uma classe",
						"São funções que não dependem de nomes, somente são declaradas e armazenadas em uma variável.",
						"Não existe esse conceito."));

		Question question3 = new Question(null, "desenvolvimento web", "easy",
				"No CSS, qual a diferença entre pseudo-classes e pseudo-elementos?",
				"Uma Pseudo classe é uma palavra chave para seletores que especificam um estado de um elemento selecionado.Um Pseudo elemento é uma palavra chave para seletores que permite estilizar alguma parte de um elemento selecionado.",
				this.createIncorrectAnswers("Não Existe diferença.",
						"Pseudo-classes são utilizado selecionar uma ação de um elemento selecionado. Já Pseudo-elementos são utilizado para estilzar todos elementos iguais semanticamente.",
						"Pseudo-classes e Pseudo-elementos não são conceitos do CSS"));

		Question question4 = new Question(null, "desenvolvimento web", "easy",
				"Quais tags HTML são usadas para exibir os dados na forma tabular?",
				"Tags: table, thead, tbody, tfoot, tr, th e td.", this.createIncorrectAnswers("Tags: div, h1 e p.",
						"Tags: header, nav, footer, a.", "Não é possível exibir tabelas com HTML."));
		Question question5 = new Question(null, "desenvolvimento web", "easy",
				"Qual a principal diferença entre CSS Grid e Flexbox?",
				"Flexbox é unidimensional, seu foco é em organizar os item em linhas OU colunas, perfeito para components internos. Já o CSS Grid é multidimensional, onde visa organizar os item em linhas e Colunas, perfeito para Layouts(cabeçalho, sidebar, entre outros).",
				this.createIncorrectAnswers("Não existe diferença.",
						"Flexbox é utilizado para alinhamento de textos e CSS grid para fontes personalizadas.",
						"Flexbox e CSS Grid não são conceitos do CSS."));

		/*
		 * questions just to seed the database
		 */
		Question question6 = new Question(null, "futebol", "medium",
				"Qual o número máximo de jogadores em uma partida de futebol", "11",
				this.createIncorrectAnswers("10", "7", "8"));
		Question question7 = new Question(null, "futebol", "easy", "Qual a maior torcida do Brasil?", "Flamengo",
				this.createIncorrectAnswers("Corinthians", "São Paulo", "Palmeiras"));
		Question question8 = new Question(null, "futebol", "hard", "Qual o ultimo campeão mundial", "Bayern",
				this.createIncorrectAnswers("Barcelona", "Palmeiras", "Goiás"));
		Question question9 = new Question(null, "futebol", "medium", "Qual o ultimo campeão da Champions League",
				"Real Madrid", this.createIncorrectAnswers("Bayern", "Barcelona", "Arsenal"));
		Question question10 = new Question(null, "futebol", "easy", "Qual time paulista não tem mundial ?", "Palmeiras",
				this.createIncorrectAnswers("Corinthians", "Santos", "Flamengo"));

		Question question11 = new Question(null, "história", "hard", "Qual tempo durou a guerra dos cem anos", "116",
				this.createIncorrectAnswers("100", "101", "110"));
		Question question12 = new Question(null, "história", "easy", "Ares era deus da?", "Guerra",
				this.createIncorrectAnswers("Águas", "Morte", "Agricultura"));
		Question question13 = new Question(null, "história", "easy", "Ano de início da 1º guerra mundial?", "1914",
				this.createIncorrectAnswers("1945", "1919", "1932"));
		Question question14 = new Question(null, "história", "medium", "Qual a denominação científca do homem moderno?",
				"Homo sapiens sapiens", this.createIncorrectAnswers("Homo erectus", "Homo sapiens", "Neandertal"));
		Question question15 = new Question(null, "história", "medium", "Qual o principal deus grego?", "Zeus",
				this.createIncorrectAnswers("Hades", "Poseiodon", "Ares"));

		this.questionRepository
				.saveAll(Arrays.asList(question1, question2, question3, question4, question5, question6, question7,
						question8, question9, question10, question11, question12, question13, question14, question15));
	}
}
