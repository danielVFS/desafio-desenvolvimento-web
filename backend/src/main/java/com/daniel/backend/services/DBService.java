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
		Question question1 = new Question(null, "Conhecimentos Gerais", "easy", "Qual o maior país do mundo?", "Russia",
				this.createIncorrectAnswers("Brasil", "India", "Estados Unidos"));
		Question question2 = new Question(null, "Conhecimentos Gerais", "medium", "Quantas casas tem o número PI?",
				"Infinitas", this.createIncorrectAnswers("Duas", "Vinte", "Milhares"));
		Question question3 = new Question(null, "Conhecimentos Gerais", "hard", "Oque a palavra LEGEND significa?",
				"Lenda", this.createIncorrectAnswers("Legenda", "Lendário", "Conto"));

		Question question4 = new Question(null, "Futebol", "medium",
				"Qual o número máximo de jogadores em uma partida de futebol", "11",
				this.createIncorrectAnswers("10", "7", "8"));
		Question question5 = new Question(null, "Futebol", "easy", "Qual a maior torcida do Brasil?", "Flamengo",
				this.createIncorrectAnswers("Corinthians", "São Paulo", "Palmeiras"));
		Question question6 = new Question(null, "Futebol", "hard", "Qual o ultimo campeão mundial", "Bayern",
				this.createIncorrectAnswers("Barcelona", "Palmeiras", "Goiás"));

		Question question7 = new Question(null, "História", "hard", "Qual tempo durou a guerra dos cem anos", "116",
				this.createIncorrectAnswers("100", "101", "110"));
		Question question8 = new Question(null, "História", "easy", "Ares era deus da?", "Guerra",
				this.createIncorrectAnswers("Águas", "Morte", "Agricultura"));
		Question question9 = new Question(null, "História", "medium", "Qual a denominação científca do homem moderno?",
				"Homo sapiens sapiens", this.createIncorrectAnswers("Homo erectus", "Homo sapiens", "Neandertal"));

		Question question10 = new Question(null, "Animais", "hard", "Qual o maior felino do mundo?", "Tigre",
				this.createIncorrectAnswers("Leão", "Onça", "Gato"));
		Question question11 = new Question(null, "Animais", "medium", "Qual o maior animal do mundo?", "Baleia-azul",
				this.createIncorrectAnswers("Rinoceronte", "Elefante", "Rato"));
		Question question12 = new Question(null, "Animais", "easy", "Qual a maior ave do Brasil?", "Avestruz",
				this.createIncorrectAnswers("Morcego", "Arara-azul", "Galinha"));

		this.questionRepository.saveAll(Arrays.asList(question1, question2, question3, question4, question5, question6,
				question7, question8, question9, question10, question11, question12));
	}
}
