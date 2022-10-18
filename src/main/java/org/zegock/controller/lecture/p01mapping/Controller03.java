package org.zegock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("ㅁ")
public class Controller03 {
	
	@RequestMapping({"sub01","sub02"})//여러 요청을 배열로 만들수도 있음
	public void method1() {
		System.out.println("03 method1 일함");
	}
	
	@RequestMapping({"ㅁ","ㅇ","ㄹㄹ","a"})
	public void method2() {
		System.out.println("03 method2 일함");
	}
	
	@RequestMapping(value="aa") // value만 있을 때는 생략 가능
	public void method3() {
		System.out.println("03 method3 일함");
	}
	
	@RequestMapping(path="bb")//value랑 같은 path. path만 있으면 역시 생략 가능.
	public void method4() {
		System.out.println("03 method4 일함");
	}
}



















