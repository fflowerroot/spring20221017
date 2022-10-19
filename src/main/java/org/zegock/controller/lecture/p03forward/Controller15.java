package org.zegock.controller.lecture.p03forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex15")
public class Controller15 {

	@RequestMapping("sub01")
	public void m1() {

	}

	// 리턴값 null도 위의 void메서드랑 같은 일 함. 요청경로가 jsp파일이름이 됨.
	@RequestMapping("sub02")
	public String m2() {
		return null;
	}

	//?
	@SuppressWarnings("null")
	@RequestMapping("sub03")
	public int m3() {
		return (Integer) null;
	}

	
	//리퀘스트파람 조건에 따라서 포워드경로 분류.
	@RequestMapping("sub04")
	public String m4(String name) {
		if (name == null)
			return null;
		return "ex15/sub051";
	}
	
	@RequestMapping("sub05")
	public String m5(String address) {
		if (address == null)
			return null;
		return "ex15/sub061";
	}

	
	@RequestMapping("sub06")
	public void m6(String address) {
		
	}
	@RequestMapping(value="sub06" , params="address")
	public String m6() {
		return "ex15/sub061";
	}
}









































