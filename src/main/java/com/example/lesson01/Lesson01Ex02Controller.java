package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// HTML 화면으로 보낸다.
@Controller // Spring bean, html로 보낼 때는 @ResponseBody가 절대 있으면 안된다.
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") //<= 404 에러는 이쪽 
	
	public String ex02() { 
		// return 되는 String는 HTML의 경로 
		// @ResponseBody가 없어야 한다.
		//	/templates/		lesson01/ex02		.html
		return "lesson01/ex02"; // response, html view의 경로 <= 500에러 이쪽
		
		
	}
}
