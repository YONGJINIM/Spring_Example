package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
@RequestMapping("/lesson03/ex02")
public class Lesson03Ex02RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("바다");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 좋아요~");

		int rowCount =  reviewBO.addReview(review);
		return "성공한 행의 개수: " + rowCount;
	}
	@RequestMapping("/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "ㅇㅅㅇ", 4.6, "맛있네요");
		return "성공한 행의 개수 : " + rowCount;
	}
	
	
	
}
