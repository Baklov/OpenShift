package com.student.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.student.demo.entity.Scores;
  
public interface ScoresRepository extends CrudRepository<Scores, Integer> {
}