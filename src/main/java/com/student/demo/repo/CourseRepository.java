package com.student.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.student.demo.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
