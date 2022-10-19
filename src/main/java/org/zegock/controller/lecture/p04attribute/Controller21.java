package org.zegock.controller.lecture.p04attribute;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex21")
public class Controller21 {
//rediret로 재요청할 때 값을 어떻게 건내줄건가?

	// 1. 쿼리스트링으로 붙여서 넘겨주기

	// 2. RedirectAttributes 사용 //이것도 쿼리스트링으로 넘어감.
	@RequestMapping("sub1")
	public String m1(RedirectAttributes rttr) {
		rttr.addAttribute("address", "서울");
		return "redirect:/ex21/sub2";
	}

	@RequestMapping("sub2")
	public void m2(String address) {
		System.out.println(address);

	}

	@RequestMapping("sub3")
	public String m3(RedirectAttributes rttr) {
		rttr.addAttribute("age", 99);
		rttr.addAttribute("email", "a@aa.com");

		return "redirect:/ex21/sub4";
	}

	@RequestMapping("sub4")
	public void m4(int age, String email) {
		System.out.println(age);
		System.out.println(email);

	}
	// 쿼리스트링으로 넘기면 문자로밖에 할 수없음 >>> 세션으로 넘기면 문자 외 가능.

}
