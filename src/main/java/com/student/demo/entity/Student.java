package com.student.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	int facNum;
	
	@OneToMany(mappedBy = "student")
	Set<Scores> marks;
	
	@Column(name ="name")
	String name;

	@Column(name ="info")
	String info;
	
	@Column(name = "age")
	int age;

	@Column(name = "egn")
	int egn;
	
	@Column(name = "sex")
	String sex;

	
	public Set<Scores> getMarks() {
		return marks;
	}

	public void setMarks(Set<Scores> marks) {
		this.marks = marks;
	}

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

		
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student() {
		super();
	}
	
	public Student(int facNum, String name, String info, int age, int egn) {
		super();
		this.facNum = facNum;
		this.name = name;
		this.info = info;
		this.age = age;
		this.egn = egn;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getFacNum() {
		return facNum;
	}
	public void setFacNum(int facNum) {
		this.facNum = facNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getEgn() {
		return egn;
	}
	public void setEgn(int egn) {
		this.egn = egn;
	}
	
	

}
