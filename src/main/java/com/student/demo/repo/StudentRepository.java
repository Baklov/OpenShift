package com.student.demo.repo;

import java.util.List;
 
import org.springframework.data.repository.CrudRepository;

import com.student.demo.entity.Student;
 
 
public interface StudentRepository extends CrudRepository<Student, Integer> {
  List<Student> findByAge(int age);
}