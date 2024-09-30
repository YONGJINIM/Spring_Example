package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01?id=13
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam("id") int id // 필수 파라미터 int id에 저장
			@RequestParam(value = "id") int id // 필수 파라미터
			// @RequestParam(value = "id", required = true) int id // 필수 파라미터
			// @RequestParam(value = "id", required = false) Integer id // 비필수 파리미터 값이 없으면 null값임
			// @RequestParam(value = "id" , defaultValue = "1") int id // 비필수 파라미터, 값이 안들어오면 1로 할당함.
	) {
//		if (id==null) {
//			id = 1; // defaultValue = "1" 를 사용하면 required = false를 사용하지 않아도 된다.
//		}
		return reviewBO.getReviewById(id); // response JSON String
	}
}
