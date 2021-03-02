package com.daniel.backend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String category;
	
	private String difficulty;
	
	private String question;
	
	private String correct_answer;
	
	@ElementCollection
	 private Set<String> incorrect_answers = new HashSet<>();

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer id, String category, String difficulty, String question, String correct_answer,
			Set<String> incorrect_answers) {
		super();
		this.id = id;
		this.category = category;
		this.difficulty = difficulty;
		this.question = question;
		this.correct_answer = correct_answer;
		this.incorrect_answers = incorrect_answers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public Set<String> getIncorrect_answers() {
		return incorrect_answers;
	}

	public void setIncorrect_answers(Set<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((correct_answer == null) ? 0 : correct_answer.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incorrect_answers == null) ? 0 : incorrect_answers.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (correct_answer == null) {
			if (other.correct_answer != null)
				return false;
		} else if (!correct_answer.equals(other.correct_answer))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (incorrect_answers == null) {
			if (other.incorrect_answers != null)
				return false;
		} else if (!incorrect_answers.equals(other.incorrect_answers))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
	
}
