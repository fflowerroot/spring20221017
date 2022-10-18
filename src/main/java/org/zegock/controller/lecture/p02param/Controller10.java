package org.zegock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("ex10")
public class Controller10 {

	@GetMapping("sub01") //required  기본값은 true  >> address 파라미터 값 없이 요청이 오면 오류.
	public void m2(@RequestParam(name="address") String address ) {
		System.out.println(address);
	}
	
	@GetMapping("sub02") //required  기본값은 true
	public void m3(@RequestParam(name="address", required = false) String address ) {
		System.out.println(address);
	}
	
	@GetMapping("sub03")// defaultValue 어트리뷰트를 사용하면 required값은 자동으로 false가 됨(true라고 지정해도)
	public void m4(@RequestParam(name="address", defaultValue = "Seoul" , required = true) String address ) {
		System.out.println(address);
	}
	
//	@GetMapping("sub05") 
//	public void m5(@RequestParam(name="address") String address
//			       @RequestParam(name="age")int age) {
//		System.out.println(address);
//		System.out.println(age);
//	}
	
	
	
}














