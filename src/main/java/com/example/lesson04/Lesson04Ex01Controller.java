package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01") // 공통 패스 /lesson04/ex01
@Controller // HTML 경로일 때는 @ResponseBody가 없음
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view" , method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // HTML의 경로
	}
	
	// 회원가입 데이터 DB insert => 결과 화면 이동
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce" , required = false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면으로 이동
		return "lesson04/afterAddUser";
	}
	// 최신 가입자 정보
	// http://localhost/lesson04/ex01/latest-user-view
	
	@GetMapping("/latest-user-view")
	// model은 항상 스프링프레임워크가 제공하는 것을 사용한다.
	public String latestUserView(Model model) {
		
		// DB select
		User user = userBO.getLatestUser();
			
		// Controller이 Model에 데이터를 집어 넣는다.
		// HTML(View)가 Model에서 꺼내서 사용한다.
		model.addAttribute("result",user);
		model.addAttribute("title","최근 가입된 유저");
				
		return "lesson04/latestUser"; // view 경로
	}
	
}
