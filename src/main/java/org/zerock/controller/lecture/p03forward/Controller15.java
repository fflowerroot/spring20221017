package org.zerock.controller.lecture.p03forward;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex15")
//@Log4j
public class Controller15 {

	@RequestMapping("sub01")
	public void m1() {

	}

	// 리턴값 null도 위의 void메서드랑 같은 일 함. 요청경로가 jsp파일이름이 됨.
	@RequestMapping("sub02")
	public String m2() {
		return null;
	}

	//??
	@SuppressWarnings("null") //? 이거 선생님이 했나?
	@RequestMapping("sub03")
	public int m3() {
		// void처럼 default view name을 사용해서 view로 포워드
		return  (Integer) null; // 그냥 반환값 인트로 한번 해봄...
	}

	
	//리퀘스트파람 조건에 따라서 포워드경로 분류.
	// sub04 요청
	// /WEB-INF/views/ex15/sub04.jsp 포워드
	@RequestMapping("sub04")
	public String m4(String name) {
		if (name == null)
			return null;
		return "ex15/sub051";
	}
	
	
	
	
	
	// sub05 요청
	// name request param이 있으면
	// /WEB-INF/views/ex15/sub051.jsp로 forward
	
	// 없으면
	// /WEB-INF/views/ex15/sub05.jsp로 forward
	@RequestMapping("sub05")
	public String m5(String address) {
		if (address == null)
			return null; // 리턴값이 널이면 void랑 같은 역할하니까.
		return "ex15/sub061";
	}

	
	
	
	// sub06 요청
		// address request param 이 있으면
		// /WEB-INF/views/ex15/sub061.jsp 로 forward
		// 없으면
		// /WEB-INF/views/ex15/sub06.jsp 로 forward
	// >>> 요청경로가 세부적인 것부터 반응하니까 충돌없음.
	@RequestMapping("sub06")
	public void m6(String address) {	
	}
	@RequestMapping(value="sub06" , params="address")
	public String m6() {
		return "ex15/sub061";
	}
}









































