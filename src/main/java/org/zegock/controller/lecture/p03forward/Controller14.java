package org.zegock.controller.lecture.p03forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex14")
public class Controller14 {
	@RequestMapping("sub01")
	public void m1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("m1");
		String path = "";
		req.getRequestDispatcher(path).forward(req, res);
	}

	//리턴벨류로 간단하게 포워드
	//뷰리저버에 의해서 프리픽스,서픽스가 붙음.(/WEB-INF/views/폴더 내의 jsp파일 이름에.)
	//      >> String리턴방법, void방법, null방법 있음.
	
	
	//스트링 리턴방법 : 스트링 리턴값이 jsp파일이름이 됨.
	@RequestMapping("sub03")
	public String m2() {
		return "xyz";
	}
	
	@RequestMapping("sub04")
	public String m3() {
		return "ex14/sub04";
	}
	
	
	//보이드 방법 :요청경로가 jsp파일이름이 됨.
	@RequestMapping("sub05")
	public void m4() {
		//m3()이랑 같은 일을 함.
	}
	
	
	
	// 리턴값 null도 위의 void메서드랑 같은 일 함. 요청경로가 jsp파일이름이 됨.
	@RequestMapping("sub06")
	public String m5() {
		return null;
	}
	
	

}



































