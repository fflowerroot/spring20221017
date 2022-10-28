package org.zerock.controller.lecture.p07mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper10;

@Controller //?
@RequestMapping("ex36")
public class Controller36 {

	@Autowired 

	private Mapper10 mapper;
	
	@RequestMapping("sub01")
	public void method1() {
		int cnt=mapper.removeCustomer();
		System.out.println(cnt+"개 삭제");
	}
	@RequestMapping("sub02")
	public void method2() {
		int cnt=mapper.removeEmployee();
		System.out.println(cnt+"개 삭제");
	}
	
	@RequestMapping("sub03")
	public void method3(@RequestParam(name="id",defaultValue="0")int id) {
		int cnt=mapper.removeCustomerById(id);
		System.out.println(cnt+"개 삭제");
	}
	@RequestMapping("sub05")
	public void method5() {
		int cnt=mapper.addCustomer();
		System.out.println(cnt+"개 입력");
	}
	
	@RequestMapping("sub06")
	public void method6() {
		int cnt=mapper.addSupplier();
		System.out.println(cnt+"개 입력");
	}
	@RequestMapping("sub061")
	public void method61() {
		int cnt=mapper.addSupplier2();
		System.out.println(cnt+"개 입력");
	}
	//java.io.FileNotFoundException: 
	//Could not open ServletContext resource
	// [/WEB-INF/props/jdbc.properties]
	
	
	@GetMapping("sub07")
	public void customerForm() {
		
	}   
	//충돌 안나는 이유는 ??
    //	   @RequestMapping은 파라미터가 있으면 여기로 오는건가? / 범위가 달라서 충돌이 안나는?
	@RequestMapping("sub07") //포스트매핑,갯매핑 둘 다 됨. 
	public void method7(JavaBean18 customer) {
		int cnt=mapper.insertCustomer(customer);
		System.out.println(cnt+"개 입력");
	}
	
	
	
	// sub07은 고객1개씩 입력 받는건데 여러고객을 List<Customer>로 인서트시키려면?
	// 인서트쿼리는 1 row씩 작성됨.
	//그래서 여러줄 쿼리를 작성해야됨
	// 매개변수 List<Customer>
	 
	
	@GetMapping("sub08")
	public void customerListForm() {
		
	}   
   //	BindingException: Parameter 'name' not found. Available parameters are [collection, customers, list]
	@RequestMapping("sub08") 
	public void method8(ArrayList<JavaBean18> customers) {
		int cnt=mapper.insertCustomers(customers);
		System.out.println(cnt);
	}
	
	
	@RequestMapping("sub09")
	public String getMethod9() {
		return "/ex36/sub07";
	} //jsp의 서브밋이 action주소로 요청을보냄? 포워드?
	@PostMapping("sub09")
	public String postMethod9(JavaBean18 customer) {
		int cnt=mapper.insertCustomerAndGetKey(customer);
		System.out.println(cnt);
		return "redirect:/ex36/sub09" ;
			
	}
	
//디스패처가 리턴타입보이드인 함수에 매핑값의 앞뒤 내용 붙여서 jsp로 포워드해줌. 
//           리턴타입이 스트링이면 스트링으로.	
	
	@RequestMapping("sub10")
	public String getMethod10() {
		return "/ex36/sub08";
	} //jsp의 서브밋이 action주소로 요청을보냄? 포워드?
	@PostMapping("sub10")
	public String postMethod10(JavaBean19 supplier, RedirectAttributes rttr) {
		int cnt=mapper.insertSupplierAndGetKey(supplier);
		System.out.println(cnt);
		rttr.addFlashAttribute("message", supplier.getId() + "번 고객 등록 완료");
		return "redirect:/ex36/sub10" ; //리디렉트 프리픽스 붙여주면 포워드 안하고 리디렉트함.
			
	}//리디렉트시나리오에서 어트리뷰트가 들어가게?
	
	

	
}



















