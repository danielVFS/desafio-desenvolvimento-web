package com.daniel.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.backend.domain.Question;
import com.daniel.backend.services.QuestionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/questions")
public class QuestionResource {

	@Autowired
	private QuestionService questionService;

	/*
	 * @GetMapping public ResponseEntity<List<Question>> index() { List<Question>
	 * questions = questionService.findAll();
	 * 
	 * return ResponseEntity.ok().body(questions); }
	 */

	@GetMapping
	public ResponseEntity<List<Question>> show(@RequestParam(value = "difficulty", defaultValue = "easy") String difficulty) {

		List<Question> questions = questionService.findByDifficulty(difficulty);

		return ResponseEntity.ok().body(questions);
	}
}
