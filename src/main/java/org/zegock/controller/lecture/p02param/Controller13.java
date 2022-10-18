package org.zegock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zegock.domain.lecture.JavaBean01;
import org.zegock.domain.lecture.JavaBean03;

@Controller 
@RequestMapping("ex13")
public class Controller13 {
	@RequestMapping("sub01")
	public void m1(JavaBean01 bean1) {
		System.out.println(bean1);
		System.out.println(bean1.getName());
		System.out.println(bean1.getEmail());
	}
//	@RequestMapping("sub03")
//	public void method3( @ RequestParam JavaBean03 params) {
//		//Required JavaBean03 parameter 'params' is not present
//		System.out.println(params);		
//	}
	
	@RequestMapping("sub03")
	public void method4( @ModelAttribute JavaBean03 params) {
		// 자바빈은 리퀘스트파라미터가 아니라 모델어트리뷰트이다.
		System.out.println(params);  
		
	}
}
