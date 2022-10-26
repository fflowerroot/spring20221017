package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 컨트롤러 수정되면 서버재시작해야함.
public class Controller01 {
//요청마다 서블릿이 필요했는데 이제는 컨트럴로로 메서드마다 요청을 받을 수 있음.
// ? 프로젝트경로(context path) 생략하는데.. 어떻게? / 서버전체 해당되는건가?
	
	
	@RequestMapping("/ex01/sub01")
	public void mthod01() {
		System.out.println("mthod01 일함");
	}
	@RequestMapping("/ex01/sub02")
	public void mthod02() {
		System.out.println("mthod02 일함");
		
		
	}
	
	
	
}
