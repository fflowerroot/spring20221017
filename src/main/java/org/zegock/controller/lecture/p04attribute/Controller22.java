package org.zegock.controller.lecture.p04attribute;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zegock.domain.lecture.JavaBean03;
import org.zegock.domain.lecture.Student;

@Controller
@RequestMapping("ex22")
public class Controller22 {
//rediret로 재요청할 때 값을 어떻게 건내줄건가?

	// 1. 쿼리스트링으로 붙여서 넘겨주기

	// 2. RedirectAttributes 사용 //이것도 쿼리스트링으로 넘어감.

	// 쿼리스트링으로 넘기면 문자로밖에 할 수없음 >>> 세션으로 넘기면 문자 외 가능.

	@RequestMapping("sub1")
	public String m1(Model model) {
		model.addAttribute("name", "ay");
		return "redirect:/ex22/sub2";
	}

	@RequestMapping("sub2")
	public void m2(Model m) {
		boolean hasName = m.containsAttribute("name");
		System.out.println(hasName);
	}

	@RequestMapping("sub3")
	public String m3(HttpSession s) {
		s.setAttribute("name", "ay");
		return "redirect:/ex22/sub4";
	}

	@RequestMapping("sub4")
	public void m4(HttpSession s) {
		Object name = s.getAttribute("name");
		System.out.println(name);
	}

	@RequestMapping("sub5")
	public String m5(HttpSession session) {
		Student s = new Student();
		session.setAttribute("student", s);
		return "redirect:/ex22/sub6";
	}

	@RequestMapping("sub6")
	public void m6(HttpSession session) {
		Object student = session.getAttribute("student");
		System.out.println(student);
	}

	// RedirectAttributes로 객체 넘기기
	@RequestMapping("sub7")
	public String m7(RedirectAttributes rttr) {
		Student student = new Student();
		rttr.addFlashAttribute("student", student);

		return "redirect:/ex22/sub8";
	}

	@RequestMapping("sub8") // 세션에 전달 후 바로 삭제
	public void m8(@ModelAttribute String student) {
		System.out.println(student);

	}
	
	
	@RequestMapping("sub9")
	public String m9(RedirectAttributes rttr, HttpServletResponse res) {
		JavaBean03 javabean03 = new JavaBean03();
		rttr.addFlashAttribute("javabean03", javabean03);

		return "redirect:/ex22/sub10";
	}

	@RequestMapping("sub10") // 세션에 전달 후 바로 삭제
	public void m10(@ModelAttribute JavaBean03 javabean03,HttpServletResponse res) throws IOException {
		System.out.println(javabean03);
		
	//	HttpServletResponse response= new HttpResponse();
		PrintWriter out = res.getWriter(); 
		
	 out.write("<h3>"+javabean03.toString()+"</h3>");
	}

}
