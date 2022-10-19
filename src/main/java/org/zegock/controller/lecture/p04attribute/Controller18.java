package org.zegock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zegock.domain.lecture.JavaBean01;
import org.zegock.domain.lecture.JavaBean03;
import org.zegock.domain.lecture.Student;

@Controller
@RequestMapping("ex18")
public class Controller18 {
	//어노테이션을 사용해서 어트리뷰트 넣기.
	// 모델을 파라미터로 넣는대신에 어노테이션으로 한번에 넣기.
	
	
	@RequestMapping("sub1")
	public void m1(@RequestParam("name")
			      @ModelAttribute("str") String s) {
		//기본객체라서(?) 안된대.
	}
	
	@RequestMapping("sub1-1")
	public void m2(@ModelAttribute("bean" ) JavaBean01 b) {
		
	}
	
	@RequestMapping("sub2")
	public void m3(@ModelAttribute("bean3") JavaBean03 b) {
		b.setScore(111);
		b.setStudentNumber("n-2323");
	}
	
	@RequestMapping("sub3")
	public void m4(@ModelAttribute() Student s) {
		s.setClassName(null);
	}
	
	
	@RequestMapping("sub04")
	public String method04(Student s) {
		s.setClassName("football");
		s.setName("son");
		s.setStudentNumber(7);
		
		return "ex18/sub03";
	}
}


































