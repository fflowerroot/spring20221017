package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.JavaBean01;
import org.zerock.domain.lecture.JavaBean03;
import org.zerock.domain.lecture.Student;

@Controller
@RequestMapping("ex18")
public class Controller18 {
	//어노테이션을 사용해서 어트리뷰트 넣기.
	// 모델을 파라미터로 넣는대신에 어노테이션으로 한번에 넣기.
	// 모델어트리뷰트 어노테이션은 리퀘스트파라미터를 가져와서 jsp페이지의(?)어트리뷰트에 넣는 역활까지!
	
	@RequestMapping("sub1")
	public void m1(@RequestParam("name")
			      @ModelAttribute("name") String s) {
		//기본객체라서(?) 안된대.
        //? @RequestParam("name")으로 받을걸 어트리뷰트에 어떻게 추가??
		//?? @ModelAttribute가 리퀘스트파라미터 name을 가져와서(???) Strig s에 넣은다음... 어트리뷰트에 어떤 이름으로 추가하지?
		// ?  >> 아마 어트리뷰트 추가됐으면 name이라는 걸로 추가됐겠지? 근데 String타입은.. 인스턴스생성이 안되서? 어트리뷰트 추가 못하나봄..
	}
	
	@RequestMapping("sub1-1")
	public void m2(@ModelAttribute("bean" ) JavaBean01 b) {
		System.out.println(b.getAddress());
	}
	
	@RequestMapping("sub2")
	public void m3(@ModelAttribute("bean3") JavaBean03 b) {
		b.setScore(111);
		b.setStudentNumber("n-2323");
		// 필드값을 리퀘스트파라미터로 받을 수도 있고, 셋메서드로 저장할 수도 있는 것 같음.
	}
	
	@RequestMapping("sub3")
	public void m4(@ModelAttribute() Student s) {
		s.setClassName(null);
		//스튜던트의 필드를 리퀘스트파라미터로 받아서 s에 저장한 다음에 필드명으로 어트리뷰트에 추가?
		// 그러니까... 필드값을 리퀘스트파라미터로 받을 수도 있고, 셋메서드로 저장할 수도 있고?
	}
	
	
	@RequestMapping("sub04")
	public String method04(Student s) {
		s.setClassName("football");
		s.setName("son");
		s.setStudentNumber(7);
		//?? 근데 브라우저에서 jsp파일에서 el 작성하지도 않았는데
		//     > Student(className=football, name=son, studentNumber=7)이거 왜 뜨는거임?
		return "ex18/sub3"; //여기로 포워드.(포워드: 이 이름의 jsp파일 보여줌) 
		//아마도 포워드가 요청 토스 안하고 파일만 가져와서 보여주는거고
		//  리다이렉트가 요청 토스하는 ..
	}
}


































