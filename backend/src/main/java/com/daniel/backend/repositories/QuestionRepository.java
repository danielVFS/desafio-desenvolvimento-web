package com.daniel.backend.repositories;

import org.springframework.stereotype.Repository;

import com.daniel.backend.domain.Question;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
