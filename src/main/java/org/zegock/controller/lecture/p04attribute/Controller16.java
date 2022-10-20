package org.zegock.controller.lecture.p04attribute;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex16")
public class Controller16 {
	// 1. 요청받고
	// 2. request parameter 수집
	// 3. request parameter 가공
	// 4. business logic
	// *5. add attribute
	// 6. forward / redirect
	
	// 포워드할 때 리퀘스트객체에 어트리뷰트를 붙여서 넘겨주기
	// 서블릿이 모델에 값을 넘겨주면 jsp가 그 값을 꺼내서 씀. (그 역활을 리퀘스트객체가 했음)
	// 리퀘스트핸들러가 모델객체에 어트리뷰트를 넣음./ 모델은 어트리뷰트들을 담고 있음.
	
	@RequestMapping("sub01")
	public void m1(HttpServletRequest req) {
		req.setAttribute("myName", "ay");
		req.setAttribute("address", "Seoul");
		
	}
}
