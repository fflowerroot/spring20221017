package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex12")
public class Controller12 {
	// 같은 이름의 리퀘스트파라미터로 요청이 올 때
	@RequestMapping("sub01")
	public void m1(String s) { //여러개의 같은 이름의 리퀘스트파라미터로 요청이 올 때
		System.out.println(s);   //  자동으로 여러개가 받아짐. 자동으로 여러개 받아지지만 굳이(?) 배열이나 컬렉션으로도 받을 수 있음.
	}
	
	@RequestMapping("sub04")
	public void m2(String name, String address, String age, String email, String password ) {
		System.out.println(name);
	}
	
	@RequestMapping("sub05")
	public void m3(String s) {
		System.out.println(s);
	}
	
	
	
}
