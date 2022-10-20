package org.zegock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller  
// 컨트롤러를 붙였다는건 컴포넌트를 .?
// 같은 어플에서 같은 이름의 빈을 만들 수 없다고?
// 패키지가 달라도 클래스 이름이 같으면 빈이름이 같아지므로 에러가남. 그래서 p02param패키지에서도 Controller이름을 08번부터 만든거임.
@RequestMapping("ex08")
public class Controller08 {
	@GetMapping("sub01")
	public void m1() {
		System.out.println("m1");
	}
	
	@GetMapping("sub02") //디스패처서블릿이 알맞은 객체를 넣어준다는? // 알맞은?
	public void m2(HttpServletRequest request) {
		System.out.println(request.toString());
		System.out.println(request);
		System.out.println(request.getParameter("n"));
		System.out.println(request.getParameter("a"));
	}
	
//	@GetMapping(path="sub03" ,params="n")
//	public void m3() {
//		System.out.println(request.toString());
//		System.out.println(request);
//		System.out.println(request.getParameter("n"));
//		System.out.println(request.getParameter("a"));
//	}
	
	
	
}


















