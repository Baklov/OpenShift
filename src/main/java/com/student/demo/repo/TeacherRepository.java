package com.student.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.student.demo.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
	 List<Teacher> findByAge(int age);
}
