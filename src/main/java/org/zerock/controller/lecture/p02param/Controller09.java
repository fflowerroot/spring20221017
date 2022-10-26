package org.zerock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// 컨트롤러를 붙였다는건 컴포넌트를 .?
// 같은 어플에서 같은 이름의 빈을 만들 수 없다고?
// 패키지가 달라도 클래스 이름이 같으면 빈이름이 같아지므로 에러가남. 그래서 p02param패키지에서도 Controller이름을 08번부터 만든거임.
@RequestMapping("ex09")
public class Controller09 {
	@GetMapping("sub01")
	public void m1() {
		System.out.println("m1");
	}

	@GetMapping("sub02") // 디스패처서블릿이 알맞은 객체를 넣어준다는?
	public void m2(HttpServletRequest request) {
		System.out.println(request.toString());
		System.out.println(request);
		System.out.println(request.getParameter("n"));
		System.out.println(request.getParameter("a"));
	}
	
	// @RequestParam : '리퀘스트 파라미터'를 '메서드 파라미터'에 바인딩할 때 쓰는 어노테이션
	@GetMapping(path = "sub03")
	public void m3(@RequestParam(name = "n") String s) {
//	public void m3(@RequestParam(value = "n") String s) { //name과 같은일을 하는 value
//	public void m3(@RequestParam("n") String s) {  //name과 value 생략가능(어트리뷰트가 1개일때)					
		System.out.println(s);
	}

		
//	@GetMapping(path="sub03" ,params="n") // 여기서 params는 리퀘스트파라미터로 받을수는 없음. 그냥 그 파라미터가 존재하는 요청을 받을뿐.
//	public void m3() {
//		System.out.println(request.toString());
//		System.out.println(request);
//		System.out.println(request.getParameter("n"));
//		System.out.println(request.getParameter("a"));
//	}

	
	
	//자동 형변환되는 타입 : 스트링, 기본타입, wrapper타입.
	@GetMapping("sub05")
	public void m4(@RequestParam(name="name") String n, 
			@RequestParam(name="age") int a ) { //리퀘스트 파라미터는 스트링인데 형변환을 자동으로 해준다!
		System.out.println(a);                
		System.out.println(n);
	}
	

	
	
	@GetMapping("sub06")
	//Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.
	//계속 위의 오류가 뜨다가.. 그냥 해결됨 ..;
	public void m5(@RequestParam(name="q") String n, 
			@RequestParam(name="age") int a ) {
		System.out.println(n);
		System.out.println(a);
	}

	
//	----충돌에러---
//	
//	@GetMapping("sub07")
//	public void m6(@RequestParam("a") String a,
//			       @RequestParam("a") double b,
//			       @RequestParam("a") Double c,
//			       @RequestParam("a") char d ) {
//		System.out.println(a+b+c+d);
//	}
//	WARN : org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
//	- Failed to bind request element: 
//		org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: 
//			Failed to convert value of type 'java.lang.String[]' to required type 'double'; 
//	nested exception is java.lang.NumberFormatException: For input string: "Seoul,1,2,c"
		
	
//	
//	@GetMapping("sub08")
//	public void m7(@RequestParam("a") String a,
//			       @RequestParam("b") double b,
//			       @RequestParam("c") Double c,
//			       @RequestParam("d") char d ) {
//		System.out.println(a+b+c+d);
//	}	
//	WARN : org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
//	- Failed to bind request element: 
//		org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: 
//			Failed to convert value of type 'java.lang.String' to required type 'double'; 
//	nested exception is java.lang.NumberFormatException: For input string: "Seoul"

}














