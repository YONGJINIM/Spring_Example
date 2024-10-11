package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;


@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	
	@Autowired
	private StudentBO studentBO; 
	
	// 학생 추가 확인
	// 주소: http://localhost/lesson04/ex02/add-student-view
	// Get 방식
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 학생 DB 추가 => 방금 가입한 학생의 화면
	@PostMapping("/add-student")
	public String addStudent( // @ModelAttribute => 객체를 한번에 받아오겠다.
			@ModelAttribute Student student, // form태그의 name과 field가 일치해야한다.
			Model model) {  
		
		// DB Insert
		studentBO.addStudent(student);
		
		// DB Select 
		Student latestStudent = studentBO.selectStudentById(student.getId());
		
		
		// Model에 가입자의 정보를 담는다.
		model.addAttribute("student" , latestStudent);
		

		
		return "lesson04/afterAddStudent"; // View의 경로 (브레이크 포인트 걸어서 확인) 
 	}
}
