package com.daniel.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.daniel.backend.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	@Query(nativeQuery = true, value = "SELECT * FROM Question ORDER BY random()")
	List<Question> findAllRandom();

	@Query(nativeQuery = true, value = "SELECT * FROM Question WHERE CATEGORY = :category ORDER BY random() LIMIT :amount")
	List<Question> findAllByCategory(String category, Integer amount);
}
