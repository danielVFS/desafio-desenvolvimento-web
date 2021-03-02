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
	
	public void databaseInstance() {
		Set<String> incorrect_answers = new HashSet<String>();
		incorrect_answers.add("mairo");
		incorrect_answers.add("bruna");
		
		Question question = new Question(null, "Gerais", "easy", "qual foi ...", "joao", incorrect_answers);
		
		this.questionRepository.saveAll(Arrays.asList(question));
	}
}
