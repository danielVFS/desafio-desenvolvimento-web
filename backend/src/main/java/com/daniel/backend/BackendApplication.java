package com.daniel.backend;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.backend.domain.Question;
import com.daniel.backend.repositories.QuestionRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<String> incorrect_answers = new HashSet<String>();
		incorrect_answers.add("2");
		incorrect_answers.add("3");
		
		Question question = new Question(null, "Gerais", "easy", "qual foi ...", "1", incorrect_answers);
		
		this.questionRepository.saveAll(Arrays.asList(question));
	}

}
