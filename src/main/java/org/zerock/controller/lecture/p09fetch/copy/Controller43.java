package org.zerock.controller.lecture.p09fetch.copy;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//페이지 전체를 로딩(?)하지 않아도 요청을 주고받을 수있음.->ajax/xhr/
//우리는 지금 ajax를 사용하는 라이브러리를 쓰지 않고 브라우저 기본메서드 fetch()를 쓰고 있음 ---> fetch말고 다른 것 써도 됨
//? 페이지로딩이라서 서브밋하면 한번에 다 보내진건가?    

// JASON : '자바스크립트 객체 표현형식'을 빌려서 데이터를 표현


@Controller
@RequestMapping("ex43")
public class Controller43 {

	@RequestMapping("sub")
	public void method1() {
		//자바스크립트가 필요해서 jsp로 포워드만하드 메서드 만듬
	}
	
	//사용자는 리퀘스트의 Accept 서버는 produces ->받는 타입과 보내는 타입이 일치해야 일을 함
	//요청범위를? 줄여서 일하게 할 수 있다
	@GetMapping("sub01")
	public void method1(String name, String address) {
		System.out.println("첫번째 메소드 일함!!!");
		System.out.println(name);
		System.out.println(address);
	}
	
	@GetMapping("sub02")
	public void method2(String email, Integer age) {
		System.out.println("두번째 메소드 일함");
		System.out.println(email); // null이 아님
		System.out.println(age); // null이 아님
	}
	
	@GetMapping("sub03")
	public void method3(String name, String email) {
		System.out.println("세번째 메소드 일함");
		System.out.println(name);
		System.out.println(email);
	}
	
	@GetMapping("sub04")
	public void method4(String address, Integer age) {
		System.out.println("네번째 메소드 일함");
		System.out.println(address); // null 아니게
		System.out.println(age); // null 아니게 
	}
	
	@PostMapping("sub05")
	public void method5(String address, Integer age) {
		System.out.println("5번 메소드 일함");
		System.out.println(address);
		System.out.println(age);
		
	}
	
	@PostMapping("sub06")
	public void method6(String name, String email) {
		System.out.println("6번 메소드 일함");
		System.out.println(name); // null 아니게
		System.out.println(email); // null아니게
	}
	
	@PostMapping("sub07")
	public void method7(String name, String email) {
		System.out.println("7번 메소드 일함");
		System.out.println(name);
		System.out.println(email);
	}
	
	@PostMapping("sub08")
	public void method8(String address, Integer age) {
		System.out.println("8번 메소드 일함");
		System.out.println(address);
		System.out.println(age);
	}
}

















