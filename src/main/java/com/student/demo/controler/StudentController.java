package com.student.demo.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Course;
import com.student.demo.entity.Scores;
import com.student.demo.entity.Student;
import com.student.demo.entity.Teacher;
import com.student.demo.repo.CourseRepository;
import com.student.demo.repo.ScoresRepository;
import com.student.demo.repo.StudentRepository;
import com.student.demo.repo.TeacherRepository;

//@CrossOrigin(origins = "http://localhost:3000")// for React
//@CrossOrigin(origins = "http://localhost:4200")// for Angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/uni")
public class StudentController {
	
	  @Autowired
	  StudentRepository repositoryForStudents;
	  @Autowired
	  ScoresRepository repositoryForScores;
	  
	  @Autowired
	  CourseRepository repositoryForCourses;
	  @Autowired
	  TeacherRepository repositoryForTeachers;
	  
	  @GetMapping("hello")
	  public String getHello(){		  
		  return "Hello Open Shift";
	  }
	  @GetMapping("students")
	  public List<Student> getAllStudents(){		  
		  List<Student> students = new ArrayList<>();		  
		  repositoryForStudents.findAll().forEach(students::add);
		  return students;
	  }
	  
	  @GetMapping("scores")
	  public List<Scores> getAllScores(){		  
		  List<Scores> scores = new ArrayList<>();		  
		  repositoryForScores.findAll().forEach(scores::add);;
		  return scores;		  
	  }
	  
	  @GetMapping("courses")
	  public List<Course> getAllCourses(){		  
		  List<Course> courses = new ArrayList<>();		  
		  repositoryForCourses.findAll().forEach(courses::add);;
		  return courses;		  
	  }
	  
	  @GetMapping("teachers")
	  public List<Teacher> getAllTeachers(){		  
		  List<Teacher> teachers = new ArrayList<>();		  
		  repositoryForTeachers.findAll().forEach(teachers::add);;
		  return teachers;		  
	  }
	  
	  @PostMapping(value = "/students/create")
	  public Student postStudent(@RequestBody Student student) {	 
	    Student studentTemp = repositoryForStudents.save(new Student(student.getFacNum(), student.getName(),student.getInfo(),student.getAge(),student.getEgn()));
	    return studentTemp;
	  }
	  
	  @PostMapping(value = "/scores/create")
	  public Scores postScore(@RequestBody Scores scores) {	 
	    Scores scoresTemp = repositoryForScores.save(new Scores(scores.getCourse(),scores.getStudent(),scores.getDateOfMark() ,scores.getMark()));
	    return scoresTemp;
	  }
	  
	  @PostMapping(value = "/teachers/create")
	  public Teacher postScore(@RequestBody Teacher teacher) {	 
		Teacher teachersTemp = repositoryForTeachers.save(new Teacher(teacher.getIdTeacher(),teacher.getEgn(),teacher.getName() ,teacher.getLevel(),teacher.getSex(),teacher.getAge()));
	    return teachersTemp;
	  }
	  
	  @PostMapping(value = "/courses/create")
	  public Course postScore(@RequestBody Course course) {	 
		  Course coursesTemp = repositoryForCourses.save(new Course(course.getIdCourse(),course.getTeacher(),course.getSubject()));
	    return coursesTemp;
	  }
	  
	  @DeleteMapping("/students/{id}")
	  public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
	    System.out.println("Delete Student with ID = " + id + "...");
	 
	    repositoryForStudents.deleteById(id);
	 
	    return new ResponseEntity<>("Student has been deleted!", HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/scores/{id}")
	  public ResponseEntity<String> deleteScores(@PathVariable("id") int id) {
	    System.out.println("Delete Score with ID = " + id + "...");
	 
	    repositoryForScores.deleteById(id);
	 
	    return new ResponseEntity<>("Score has been deleted!", HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/courses/{id}")
	  public ResponseEntity<String> deleteCourses(@PathVariable("id") int id) {
	    System.out.println("Delete Course with ID = " + id + "...");
	 
	    repositoryForCourses.deleteById(id);
	 
	    return new ResponseEntity<>("Course has been deleted!", HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/teachers/{id}")
	  public ResponseEntity<String> deleteTeachers(@PathVariable("id") int id) {
	    System.out.println("Delete Teacher with ID = " + id + "...");
	 
	    repositoryForTeachers.deleteById(id);
	 
	    return new ResponseEntity<>("Teacher has been deleted!", HttpStatus.OK);
	  }
	  
	  @GetMapping(value = "students/age/{age}")
	  public List<Student> findByAge(@PathVariable int age) {
	 
	    List<Student> student = repositoryForStudents.findByAge(age);
	    return student;
	  }
	  
	  @GetMapping(value = "teachers/age/{age}")
	  public List<Teacher> findOfTeacherByAge(@PathVariable int age) {
	 
	    List<Teacher> teacher = repositoryForTeachers.findByAge(age);
	    return teacher;
	  }
	  
	  @PutMapping("/students/{id}")
	  public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
	    System.out.println("Update Student with ID = " + id + "...");
	 
	    Optional<Student> studentData = repositoryForStudents.findById(id);
	 
	    if (studentData.isPresent()) {
	      Student studentTemp = studentData.get();
	      studentTemp.setName(student.getName());
	      studentTemp.setAge(student.getAge());
	      studentTemp.setEgn(student.getEgn());
	      studentTemp.setInfo(student.getInfo());
	      
	      return new ResponseEntity<>(repositoryForStudents.save(studentTemp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PutMapping("/teachers/{id}")
	  public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher) {
	    System.out.println("Update Teacher with ID = " + id + "...");
	 
	    Optional<Teacher> teacherData = repositoryForTeachers.findById(id);
	 
	    if (teacherData.isPresent()) {
	      Teacher teacherTemp = teacherData.get();	     
	      
	      return new ResponseEntity<>(repositoryForTeachers.save(teacherTemp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PutMapping("/courses/{id}")
	  public ResponseEntity<Course> updateCourse(@PathVariable("id") int id, @RequestBody Course course) {
	    System.out.println("Update Course with ID = " + id + "...");
	 
	    Optional<Course> courseData = repositoryForCourses.findById(id);
	 
	    if (courseData.isPresent()) {
	      Course courseTemp = courseData.get();	     
	      
	      return new ResponseEntity<>(repositoryForCourses.save(courseTemp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PutMapping("/scores/{id}")
	  public ResponseEntity<Scores> updatescore(@PathVariable("id") int id, @RequestBody Scores score) {
	    System.out.println("Update Score with ID = " + id + "...");
	 
	    Optional<Scores> scoreData = repositoryForScores.findById(id);
	 
	    if (scoreData.isPresent()) {
	      Scores scoreTemp = scoreData.get();
//	      scoreTemp.setSubject(score.getSubject());
	      scoreTemp.setMark(score.getMark());
	      
	      return new ResponseEntity<>(repositoryForScores.save(scoreTemp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  
}
