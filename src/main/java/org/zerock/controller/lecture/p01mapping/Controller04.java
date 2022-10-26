package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex04")
public class Controller04 {
//요청마다 서블릿이 필요했는데 이제는 컨트럴로로 메서드마다 요청을 받을 수 있음.
// ? 프로젝트경로(context path) 생략하는데.. 어떻게? / 서버전체 해당되는건가?
	@RequestMapping("sub01")
	public void mthod01() {
		System.out.println("mthod01 일함");
	}

	@RequestMapping(value = "sub02", method = RequestMethod.GET)
	public void mthod02() {
		System.out.println("mthod02 일함");

	}

	@RequestMapping(value = "sub03", method = {RequestMethod.GET, RequestMethod.POST})//요청방식도 배열로 만들 수 있음. 그러나 불필요.(?)
	public void mthod03() {                                       // >  왜냐하면 어차피 method 생략하면 두가지 방식 모두 받음...
		System.out.println("mthod03 일함");

	}

}












