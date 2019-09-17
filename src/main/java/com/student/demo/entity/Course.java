package com.student.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@Column(name ="IdCourse")
	int idCourse;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTeacher")	
	Teacher teacher;
	
	@Column(name ="subject")
	String Subject;

	

	public Course(int idCourse, Teacher teacher, String subject) {
		super();
		this.idCourse = idCourse;
		this.teacher = teacher;
		Subject = subject;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}
	
}
