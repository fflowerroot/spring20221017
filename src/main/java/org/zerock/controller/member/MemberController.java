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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;

@Component
@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	MemberService service;

	@GetMapping("register")
	public void m1() {
	}

//	@PostMapping("register")
//	public String m11(MemberDto member, RedirectAttributes rttr, HttpServletRequest req) {
////		req.setAttribute("m", "reqattr"); //이건 보내온 요청에 붙여서 넘겨주는건데 여기서는 다른 곳으로 리디렉트하기 때문에 이 어트리뷰트는 볼 수 없음. 보려면 요청을 보내온 페이지로 포워드해야함.
//
//		// sign in
//		if (member.getPassword() == member.getPassword2()) {
//			int cnt = service.insert(member);
//			if (cnt == 1)
//				rttr.addFlashAttribute("message", "회원가입 되었습니다");
//			return "redirect:/member/list";
//		} else {
//			return wrongPassword();
//			
//		}
//
//		// ★★ !!? return "redirect: /member/list"; 이렇게 공백이 있었음
//		// -> 이 주소로 리디렉트는 되는데 리디렉트어트리뷰트는 안넘어가졌음.
//	}

//	@ResponseBody
//	public String wrongPassword() {
//		return "비밀번호가 일치하지 않습니다";
//	}
	@ResponseBody
	@PostMapping("register")
	public String m11(MemberDto member, RedirectAttributes rttr, HttpServletRequest req) {
//		req.setAttribute("m", "reqattr"); //이건 보내온 요청에 붙여서 넘겨주는건데 여기서는 다른 곳으로 리디렉트하기 때문에 이 어트리뷰트는 볼 수 없음. 보려면 요청을 보내온 페이지로 포워드해야함.

		// sign in
		if (member.getPassword() == member.getPassword2()) {
			int cnt = service.insert(member);
			if (cnt == 1)
				rttr.addFlashAttribute("message", "회원가입 되었습니다");
			return "redirect:/member/list";
		} else {
			return wrongPassword();
			
		}

		// ★★ !!? return "redirect: /member/list"; 이렇게 공백이 있었음
		// -> 이 주소로 리디렉트는 되는데 리디렉트어트리뷰트는 안넘어가졌음.
	}

	@GetMapping("list")
	public void m2(Model model) {
		List<MemberDto> memberList = service.select();
		model.addAttribute("memberList", memberList);
//	model.addAllAttributes(memberList); //이건 뷰에서 뭐로 꺼내?
	}

	@GetMapping("get")
	public void m3() {
	}

	@GetMapping("modify")
	public void m4() {
	}

	@PostMapping("modify")
	public String m33() {
		return "redirect:/";
	}
}
