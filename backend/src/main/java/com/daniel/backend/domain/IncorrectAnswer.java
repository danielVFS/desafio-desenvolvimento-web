package com.daniel.backend.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class IncorrectAnswer {

	@NotNull
	private String incorrect_answer;

	public IncorrectAnswer(@NotNull String incorrect_answer) {
		super();
		this.incorrect_answer = incorrect_answer;
	}

	public String getIncorrect_answer() {
		return incorrect_answer;
	}

	public void setIncorrect_answer(String incorrect_answer) {
		this.incorrect_answer = incorrect_answer;
	}

}
