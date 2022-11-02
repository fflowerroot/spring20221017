package org.zerock.controller.lecture.p09fetch.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex40")
public class Controller40 {

	@RequestMapping("sub0")
	public void method1() {
		//jsp로 포워드만 하는 메서드
	}
	
	@RequestMapping("sub01")
	public void method2() {
		System.out.println("01");
	}
	
//	@RequestMapping(path="sub04", method=RequestMethod.PUT)
	@PutMapping("sub04")
	public void m4() {
	}
	
	@DeleteMapping("sub04")
	public void m5() {
		System.out.println("de");
	}
	
	@DeleteMapping("sub05")
	public void m6() {
		System.out.println("de");
	}
	@GetMapping("sub05")
	public void m61() {
		System.out.println("de");
	}	
	@PostMapping("sub05")
	public void m62() {
		System.out.println("de");
	}	
	@PutMapping("sub05")
	public void m63() {
		System.out.println("de");
	}
}

			//  CRUD      HTTP Method

			// CREATE  : 	POST
			// READ	   :    GET
			// UPDATE  :	PUT
			// DELETE  :	DELETE


//put방식 delete방식은 어떻게 작동?



// ? 유니코드에서->바이트시퀀스 /유니코드도 숫자고 바이트시퀀스도 숫자인데 뭘 어떻게 변경한다는거?
























