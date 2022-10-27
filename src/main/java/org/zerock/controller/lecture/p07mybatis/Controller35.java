package org.zerock.controller.lecture.p07mybatis;
// 11,12,1월. 11월프로젝트는 선생님이랑 같이.(팀없음.혼자) /3번째 기업섭외안될수도. 기업프로젝트는 선택사항- 안하면 2번째 프로젝트 보완 혹은 개인,팀 프로젝트.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;
import org.zerock.mapper.lecture.Mapper09;

@Controller //?
@RequestMapping("ex35")
public class Controller35 {
	
	//오토커밋이 되는건가?

	@Autowired // ?
	// Mapper09인터페이스를 autowired.
	private Mapper09 mapper;
	
	@RequestMapping("sub01")
	public void method1() {
		String name1 = mapper.getCustomerNameById(1);
		String name2 = mapper.getCustomerNameById(9);
		
		System.out.println(name1);
		System.out.println(name2);
	}
	@RequestMapping("sub02")
	public void method2() {
		String name1 = mapper.getEmployeeFirstNameById(0);
		String name2 = mapper.getCustomerNameById(9);
		
		System.out.println(name1);
		System.out.println(name2);
	}
	@RequestMapping("sub03") // 파라미터가 2개이상일때만 파라미터 이름에 매핑되고 1개일땐 이름 상관없이 매핑되는건가?
	public void method3() {
//		List<String> berlin = mapper.getCustomerNameByCityAndCountry("Berlin", "Germany");
//		List<String> london = mapper.getCustomerNameByCityAndCountry("London", "UK");
		
		List<String> berlin = mapper.getCustomerNameByCityAndCountry("Germany", "Berlin");
		List<String> london = mapper.getCustomerNameByCityAndCountry("UK", "London");
		
		System.out.println(berlin);
		System.out.println(london);
	}
	
//	@RequestMapping("sub04")
//	public void method4() {
//		String berlin = mapper.getCustomerNameByCityAndCountry2("Berlin", "Germany");
//		String london = mapper.getCustomerNameByCityAndCountry2("London", "UK");
//		
//		System.out.println(berlin);
//		System.out.println(london);
//	}
	
	@RequestMapping("sub04")
	public void method4() {
		List<String> londona = mapper.getSupplierNameByCityAndCountry("UK", "Londona");
		List<String> newOl = mapper.getSupplierNameByCityAndCountry("USA", "New Orleans");
		
		System.out.println(londona); // Exotic Liquid
		System.out.println(newOl); // New Orleans Cajun Delights
	}
	
	// /ex35/sub05?name=Alfreds Futterkiste&country=Germany
	// ---> Maria Anders
	// /ex35/sub05?name=Antonio Moreno Taquería&country=Mexico
	// ---> Antonio Moreno
	
	@RequestMapping("sub05") //파라미터로 아무것도 안들어오면 null반환됨.
	public void method5(JavaBean04 p) { //@RequestMapping이 붙으면 파라미터목록? 에서 찾아?
		String c1 = mapper.getContactName(p);
		System.out.println(c1);
	}
	//파라미터가 1개이고 빈일 때는 xml파일에서 프로퍼티명으로 바로 써준다.
	
	// /ex35/sub06?name=New Orleans Cajun Delights&country=USA
	// ---> Shelley Burke
	
	
	// /ex35/sub06?name=Grandma Kelly's Homestead&country=USA
	// ---> Regina Murphy
	@RequestMapping("sub06")
	public void method6(JavaBean04 b) { // 파리미터목록에서 찾음 // ??
		String c = mapper.getSupplierContactName(b);
		System.out.println(c);
	}
	
	
	// /ex35/sub07?categoryId=1&price=10.00
	// /ex35/sub07?categoryId=2&price=20.00
	@RequestMapping("sub07")
	public void method7(JavaBean16 p1, JavaBean17 p2) {
		
		List<String> list = mapper.getProductName(p1, p2);
		list.forEach(System.out::println);
	}
	
	
}






