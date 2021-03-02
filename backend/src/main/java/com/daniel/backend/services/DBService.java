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
		Question question = new Question(null, "Gerais", "easy", "qual foi ...", "joao",
				this.createIncorrectAnswers("1", "2", "3"));
		Question question2 = new Question(null, "Gerais", "easy", "qual foi ...", "joao",
				this.createIncorrectAnswers("1", "2", "3"));

		this.questionRepository.saveAll(Arrays.asList(question, question2));
	}
}
