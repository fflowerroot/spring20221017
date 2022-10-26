package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")// 슬래시 생략가능
public class Controller02 {
//요청마다 서블릿이 필요했는데 이제는 컨트럴로로 메서드마다 요청을 받을 수 있음.
	@RequestMapping("/sub01")
	public void mthod01() {
		System.out.println("mthod01 일함");
	}
	@RequestMapping("sub02") // 슬래시 생략가능
	public void mthod02() {
		System.out.println("mthod02 일함");
		
		
	}
	
	
	
}
