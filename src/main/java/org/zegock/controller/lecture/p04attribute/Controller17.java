package org.zegock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zegock.domain.lecture.JavaBean03;
import org.zegock.domain.lecture.Student;

@Controller
@RequestMapping("ex17")
public class Controller17 {
	// 포워드할 때 리퀘스트객체에 어트리뷰트를 붙여서 넘겨주기
	// 서블릿이 모델에 값을 넘겨주면 jsp가 그 값을 꺼내서 씀. (그 역활을 리퀘스트객체가 했음)
	// 리퀘스트핸들러가 모델객체에 어트리뷰트를 넣음./ 모델은 어트리뷰트들을 담고 있음.
	
	@RequestMapping("sub01")
	public void m1(Model model) {
		model.addAttribute("myName","ay");
		//디스패쳐서블릿이 모든 요청을 받음.
		// 모델에 넣어놨지만 디스패처서블릿이 리퀘스트에 옮겨담음.
	}
	
	@RequestMapping("sub2")
	public void m2(Model m) {
		m.addAttribute("email","ab@daum.net");
	}
	
	@RequestMapping("sub3")
	public void m3(Model model) {
		model.addAttribute("email","ab@daum.net");
		model.addAttribute("name", "ay");
		model.addAttribute("age", "11");
		model.addAttribute("address", "ay-165-Iteawon");		
	}
	
	@RequestMapping("sub4")
	public void m4(Model model) {
		JavaBean03 obj=new JavaBean03();
		obj.setAvg(11);
		obj.setClassName("ayclass");
		model.addAttribute("student", obj);
		
	}
	
	@RequestMapping("sub5")
	public void m5(Model model) {
		//자바빈이름과 어트리뷰트이름이 같으면 >> 어트리뷰트명 생략가능
		// > 그런데 퍼블릭 타입이 아니면 가져올 수 없음. 아마도.
		//    >> 그리고 클래스파일이 퍼블릭이려면 파일이 따로 존재해야함
		            //The public type Student must be defined in its own file
		Student s= new Student();
		s.setName("stu-ay");
		//model.addAttribute("student",s);
		model.addAttribute(s);
	}
	
}

// class Student{
//	private String studentName;
//	public void setStudentName(String studentName) {
//		this.studentName=studentName;
//	}
//}


































