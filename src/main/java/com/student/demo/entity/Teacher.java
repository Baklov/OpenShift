package com.student.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {	
	@Id
	@Column(name ="idTeacher")
	int idTeacher;
	@OneToMany(
				mappedBy = "teacher", 
				cascade = CascadeType.ALL
			)
	private List<Course> courses;
	
	@Column(name ="egn")
	int egn;
	@Column(name ="name")
	String name;

	@Column(name ="level")
	String level;
	@Column(name ="sex")
	String sex;
	
	@Column(name ="age")
	int age;

	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
		courses.forEach( teacher->
	        {
	            teacher.setTeacher(this);
	        });
	}
	public int getEgn() {
		return egn;
	}
	public void setEgn(int egn) {
		this.egn = egn;
	}
	public Teacher(int idTeacher, int egn, String name, String level, String sex, int age) {
		super();
		this.idTeacher = idTeacher;
		this.egn = egn;
		this.name = name;
		this.level = level;
		this.sex = sex;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
