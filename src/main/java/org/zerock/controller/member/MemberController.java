package org.zerock.controller.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("register")
	public void m1() {}
	
	@PostMapping("register")
	public String m11() {
		//sign in
		
		return "redirect: /member/register";
	}
	
	@GetMapping("list")
	public void m2() {}
	

}
