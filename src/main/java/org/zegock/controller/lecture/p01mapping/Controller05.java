package org.zegock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//GetMapping, PostMapping, PutMapping, PatchMapping, DeleteMapping
@Controller
@RequestMapping("ex05")
public class Controller05 {
	
	@RequestMapping(value = "sub01", method = RequestMethod.GET)
	// @GetMapping("sub02") // 위의 코드와 같은 일을함.
	public void mthod01() {
		System.out.println("method01 일함");
	}

	@GetMapping("sub02") 
	public void mthod02() {
		System.out.println("method02 일함");
	}
//	@GetMapping("sub02") // 같은 이름의 요청인데.. 누가 일할까? > 충돌나서 에러남.
//						// 다만 요청 범위(내용)가 다르면 충돌 안나고 좁은 범위의 것부터 요청됨.
//	public void mthod022() {
//		System.out.println("method022 일함");
//	}
	
	@PostMapping("sub02")
	public void method03() {
		System.out.println("method03 일함");
	}
}
