package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("ex07")
public class Controller07 {
	@GetMapping(path="sub03", params="address")// 리퀘스트 파라미터도 설정 가능. //이렇게 뒤에 무엇을 붙이는건 요청범위를 구체적으로 좁히는 것임. 
	public void m1() {
		System.out.println("m1");
	}
	
	
}
