package org.zerock.controller.lecture.p09fetch.copy;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//페이지 전체를 로딩하지 않아도 요청을 주고받을 수있음.->ajax/xhr/
//우리는 지금 ajax를 사용하는 라이브러리를 쓰지 않고 브라우저 기본메서드 fetch()를 쓰고 있음 ---> fetch말고 다른 것 써도 됨
                           
@Controller
@RequestMapping("ex42")
public class Controller42 {

	@RequestMapping("sub")
	public void method() {
		//자바스크립트가 필요해서 jsp로 포워드만하드 메서드 만듬
	}
	
	//사용자는 리퀘스트의 Accept 서버는 produces ->받는 타입과 보내는 타입이 일치해야 일을 함
	//요청범위를? 줄여서 일하게 할 수 있다
	
	// produces는 리퀘스트헤더의 Accept정보와 매칭됨
	// ? 그래서 Accept가 뭐야
	@GetMapping(path = "sub01", produces = "text/plain")
	public void method1() {
		System.out.println("/ex42/sub01 메소드 일함");
	}
	
	@GetMapping(path = "sub01", produces = "text/html")
	public void method2() {
		System.out.println("/ex42/sub02 메소드 일함");
	}
}
	











