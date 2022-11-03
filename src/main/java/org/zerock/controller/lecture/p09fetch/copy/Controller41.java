package org.zerock.controller.lecture.p09fetch.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex41")
public class Controller41 {

	@RequestMapping("sub")
	public void method1() {
		//자바스크립트가 필요해서 jsp로 포워드만하드 메서드 만듬
	}
	
}


// ?  지금까지 사용자가 버튼으로 요청하는게 폼에 서브밋 밖에 없었나? 서브밋은 리디렉트? 그래서  url이 바뀜?
//   ->url이 바뀌면 페이지 전체 로딩인데 js의 fetch함수 적용된 버튼 누르면 url안바뀌고 요청이러서 전체 로딩 아님? 
//      -> 그렇다면 새로운 view파일이 아닌 다른 무언가가 바뀌어야하는데 그걸 어떻게 만듬 ? 






