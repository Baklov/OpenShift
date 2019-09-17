package com.student.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Scores")
public class Scores {

	@Id
	int idScore;	
	
	@ManyToOne
	@JoinColumn(name = "idCourse")
	Course course;
	
	@ManyToOne
	@JoinColumn(name = "facNum")    
	Student student;
	
	@Column(name ="dateOfMark")
	LocalDateTime dateOfMark;	
	
	@Column(name ="mark")
	int mark;
	
	public int getIdScore() {
		return idScore;
	}

	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}
	
		
	public Scores() {
		super();
	}
		
	public Scores(Course course, Student student, LocalDateTime dateOfMark, int mark) {
		super();
		this.course = course;
		this.student = student;
		this.dateOfMark = dateOfMark;
		this.mark = mark;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDateTime getDateOfMark() {
		return dateOfMark;
	}

	public void setDateOfMark(LocalDateTime dateOfMark) {
		this.dateOfMark = dateOfMark;
	}
		

	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}

}
