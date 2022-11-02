package org.zerock.controller.lecture.p09fetch.copy;

import javax.servlet.jsp.PageContext;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.lecture.JavaBean20;

//페이지 전체를 로딩(?)하지 않아도 요청을 주고받을 수있음.->ajax/xhr/
//우리는 지금 ajax를 사용하는 라이브러리를 쓰지 않고 브라우저 기본메서드 fetch()를 쓰고 있음 ---> fetch말고 다른 것 써도 됨
//? 페이지로딩이라서 서브밋하면 한번에 다 보내진건가?    

// JASON : '자바스크립트 객체 표현형식'을 빌려서 데이터를 표현
// jason 사용하는 이유 : 객체로 변환하기 유용

@Controller
@RequestMapping("ex44")
public class Controller44 {

	@RequestMapping("sub")
	public void method1() {
		//자바스크립트가 필요해서 jsp로 포워드만하드 메서드 만듬
	}
	
	//사용자는 리퀘스트의 Accept 서버는 produces ->받는 타입과 보내는 타입이 일치해야 일을 함
	//요청범위를? 줄여서 일하게 할 수 있다
	@PostMapping("sub01")
	public void method01(String name, String address) {
		System.out.println("1번 메소드 일함");
		System.out.println(name);
		System.out.println(address);
	}
	

	
	@PostMapping("sub02")
	public void method02(@RequestBody String data) {
		System.out.println("2번 메소드 일함");
		System.out.println(data);
	}
	
	@PostMapping("sub03")
	public void method03(@RequestBody JavaBean20 data) {
		System.out.println("3번 메소드 일함");
		System.out.println(data);
	}
}










