package org.zerock.controller.lecture.p04attribute;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex19")
public class Controller19 {
	
	@RequestMapping("sub1")
	public void m1(HttpServletResponse response) throws IOException {
		String location = "sub2";
		response.sendRedirect(location);
	}

	@RequestMapping("sub5")
	public String m3() {
		return "redirect:sub6";
	}
	
	@RequestMapping("sub7")
	public void m4(HttpServletResponse res, HttpServletRequest req) throws IOException {
		String loc= req.getContextPath()+"/ex19/sub8";
//		System.out.println(req.getContextPath());
		res.sendRedirect(loc);
		System.out.println("222"+req.getContextPath()); // 여기 위치해도 실행됨. 그니까 리다이렉트가 함수 종료는 아니라는거지.
	}

	@RequestMapping("sub9")
	public String m5() {
		return "redirect:/ex19/sub10";
	}
}
