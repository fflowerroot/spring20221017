package org.zerock.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;

@Component
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("register")
	public void m1() {}
	
	@PostMapping("register")
	public String m11(MemberDto member,HttpServletRequest req) {
		//sign in
		int i=service.insert(member);
		if(i==1) req.setAttribute("message", "회원등록이 되었습니다");
		else req.setAttribute("message", "회원등록이 되지 않았습니다");
		return "redirect: /member/list";
		
	}
	
	@GetMapping("list")
	public void m2(Model model) {
	List<MemberDto> memberList = service.select();
	model.addAttribute("memberList",memberList);
//	model.addAllAttributes(memberList);
	}
}

















