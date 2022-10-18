package org.zegock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("ex11")
public class Controller11 {

	@GetMapping("sub01")
	public void m1(@RequestParam("address") String abc) {
		System.out.println(abc);
	}

	// /ex11/sub02?address=seoul
	@GetMapping("sub02")
	public void method2(@RequestParam String address) {
		// request param 의 이름과 method argument의 이름이 같으면
		// @RequestParam의 value 속성 생략 가능
		System.out.println(address);
	}
	
	// /ex11/sub03?address=korea
	@GetMapping("sub03")
	public void method3(String address) {
		// 메소드 파라미터가 기본타입(8개, 또는 wrapper), String이면
		// @RequestParam이 붙은 것으로 간주
		
		System.out.println(address);
	}
	
	@GetMapping("sub04")
	public void m4(String city, int age, String name) {
		System.out.println(city);
		System.out.println(age);
		System.out.println(name);
	}
	
	@GetMapping("sub09")
	public void method9(@RequestParam("a") String a,
						@RequestParam("b") double b,
						@RequestParam("c") Double c,
						@RequestParam("d") int d,
						@RequestParam("e") Integer e
						) {
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
	}
	
	
	
}














