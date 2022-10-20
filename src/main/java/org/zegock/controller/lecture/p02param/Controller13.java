package org.zegock.controller.lecture.p02param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zegock.domain.lecture.Customer;
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
	@RequestMapping("a")
	public void method5( @RequestParam("i") String[] i) {
	//	Log.info("array i : " + Arrays.toString(i));  // 책 133인데.. 안되는데..
	//	return "ex13/a";
		System.out.println(Arrays.toString(i));
		for(String s:i) System.out.println(s);
	}
	
	@RequestMapping("aab")// aab로 온 요청을 받아서 처리하고? 리턴값으로 (요청을 하는게 아니라) 리턴값의 이름에 맞는 jsp파일을 찾음? 
	public String m6(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println(ids);
		//return "a?i=1";   // jsp파일을 찾는건데 특수기호가 포함되어있어서 아예 존재불가해서 찾기 시도조차 안하는건가? > 시도는 했는데 브라우저에서는 안떴네.
//		WARN : org.springframework.web.servlet.PageNotFound - No mapping found for HTTP request with URI [/controller/WEB-INF/views/a] in DispatcherServlet with name 'appServlet'
		return "b"; 
	}
	
	@RequestMapping("b")
	public void m7() {   //위의 aa요청은 forward로 b.jsp파일을 찾으니까.. url b로 요청이 오는건 아닌가봐.
		System.out.println(77);
	}
	
	@RequestMapping("c")
	public void m8 (@RequestParam("p") ArrayList<Customer> c) {// Customer타입은 기본형,wrapper,String이 아니니까 자동형변환 안됨.		
		System.out.println(c.toString());
	}
	
}





















