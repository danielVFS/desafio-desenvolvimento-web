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
	
	private String correct_question;
	
	@ElementCollection
	 private Set<String> incorrect_answers = new HashSet<>();
}
