package org.zerock.controller.lecture.p09fetch.copy;

import javax.servlet.jsp.PageContext;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.lecture.JavaBean20;
import org.zerock.domain.lecture.JavaBean21;
import org.zerock.domain.lecture.JavaBean22;
import org.zerock.domain.lecture.JavaBean23;
import org.zerock.domain.lecture.JavaBean25;
import org.zerock.domain.lecture.JavaBean27;

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
	
	@PostMapping("sub04")
	public void method04(@RequestBody JavaBean21 data) {
		System.out.println(data);
	}
	
	@PostMapping("sub05")
	public void method05(@RequestBody JavaBean22 data) {
		System.out.println(data);
	}
	
	@PostMapping("sub06")
	public void method06(@RequestBody JavaBean23 data) {
		System.out.println(data);
	}
	
	@PostMapping("sub07")
	public void method07(@RequestBody JavaBean25 data) {
		System.out.println(data);
	}
	
	@PostMapping("sub14")
	public void method14(@RequestBody JavaBean27 data) {
		System.out.println(data);
	}
	@PostMapping("sub15/{아무이름}")
	public void method15(@PathVariable("아무이름") String 아무이름 ){
		System.out.println(아무이름);
	}
	// path variable 자동 형변환
		// 파라미터명과 path variable 이름 같으면 value 속성 생략 가능
		@GetMapping("sub16/{d}")
		public void method16(@PathVariable int d) {
			System.out.println(d); // 99
		}
	}


// 여기까지 사용자가 서버에게 ajax 요청보내는 것 알아봄/
//이제 서버에서 사용자에게 응답 보내는 것 알아볼 것임


//?  지금까지 사용자가 버튼으로 요청하는게 폼에 서브밋 밖에 없었나? 서브밋은 리디렉트? 그래서  url이 바뀜?
//->url이 바뀌면 페이지 전체 로딩인데 js의 fetch함수 적용된 버튼 누르면 url안바뀌고 요청이러서 전체 로딩 아님? 
// -> 그렇다면 새로운 view파일이 아닌 다른 무언가가 바뀌어야하는데 그걸 어떻게 만듬 ? 
//    -> 지금까지는 컨트롤러의 메서드가 보이드 타입이라서 jsp파일을 보여주는 거였음. 이제부터는 jsp파일이 아니라
//        ajax로 응답해주는 것 할거임.






























