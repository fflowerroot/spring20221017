package org.zegock.controller.lecture.p04attribute;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex20")
public class Controller20 {
//rediret로 재요청할 때 값을 어떻게 건내줄건가?

	
	//쿼리스트링으로 붙여서 넘겨주기
	@RequestMapping("sub1")
	public String m1() {
		return "redirect:/ex20/sub2?name=ay";
	}
	
	@RequestMapping("sub2")
	public String m2(String name) {
		System.out.println("sub2로 redirect");
		System.out.println(name);
		return null;
	}
	
	
}
