package com.daniel.backend.repositories;

import org.springframework.stereotype.Repository;

import com.daniel.backend.domain.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	@Query(nativeQuery = true, value = "SELECT *  FROM Question ORDER BY random()") 
	List<Question> findAllRandom();
	
	@Query(nativeQuery = true, value = "SELECT * FROM Question WHERE DIFFICULTY = :difficulty")
	List<Question> findAllByDifficulty(String difficulty);
}
