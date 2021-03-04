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

		Question question1 = new Question(null, "futebol", "medium",
				"Qual o número máximo de jogadores em uma partida de futebol", "11",
				this.createIncorrectAnswers("10", "7", "8"));
		Question question2 = new Question(null, "futebol", "easy", "Qual a maior torcida do Brasil?", "Flamengo",
				this.createIncorrectAnswers("Corinthians", "São Paulo", "Palmeiras"));
		Question question3 = new Question(null, "futebol", "hard", "Qual o ultimo campeão mundial", "Bayern",
				this.createIncorrectAnswers("Barcelona", "Palmeiras", "Goiás"));
		Question question4 = new Question(null, "futebol", "medium", "Qual o ultimo campeão da Champions League",
				"Real Madrid", this.createIncorrectAnswers("Bayern", "Barcelona", "Arsenal"));
		Question question5 = new Question(null, "futebol", "easy", "Qual time paulista não tem mundial ?", "Palmeiras",
				this.createIncorrectAnswers("Corinthians", "Santos", "Flamengo"));

		Question question6 = new Question(null, "história", "hard", "Qual tempo durou a guerra dos cem anos", "116",
				this.createIncorrectAnswers("100", "101", "110"));
		Question question7 = new Question(null, "história", "easy", "Ares era deus da?", "Guerra",
				this.createIncorrectAnswers("Águas", "Morte", "Agricultura"));
		Question question8 = new Question(null, "história", "easy", "Ano de início da 1º guerra mundial?", "1914",
				this.createIncorrectAnswers("1945", "1919", "1932"));
		Question question9 = new Question(null, "história", "medium", "Qual a denominação científca do homem moderno?",
				"Homo sapiens sapiens", this.createIncorrectAnswers("Homo erectus", "Homo sapiens", "Neandertal"));
		Question question10 = new Question(null, "história", "medium", "Qual o principal deus grego?", "Zeus",
				this.createIncorrectAnswers("Hades", "Poseiodon", "Ares"));

		this.questionRepository.saveAll(Arrays.asList(question1, question2, question3, question4, question5, question6,
				question7, question8, question9, question10));
	}
}
