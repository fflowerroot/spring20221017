package org.zerock.controller.lecture.p07mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.Javabean18;
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
	public void method7(Javabean18 customer) {
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
	public void method8(ArrayList<Javabean18> customers) {
		int cnt=mapper.insertCustomers(customers);
		System.out.println(cnt);
	}
}



















