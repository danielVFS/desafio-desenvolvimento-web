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
	public ResponseEntity<List<Question>> show(
			@RequestParam(value = "category", defaultValue = "futebol") String category,
			@RequestParam(value = "amount", defaultValue = "2") String amount) {
		
		List<Question> questions = questionService.findByCategory(category, Integer.parseInt(amount));

		return ResponseEntity.ok().body(questions);
	}
}
