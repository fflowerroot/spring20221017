package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper11;
//우리가 하는 일 대부분이 db의 crud.
//업데이트할건데 정보 먼저 보여주고 수정하는 방식으로 할거임.


//모델에 담기는 것을 보통 빈으로 만들었음.
//순수한 데이터 처리 로직이 우리가 만든 Mapper. (DAO나 Repository 등으로 부름.) 

@Controller
@RequestMapping("ex37")
public class Controller37 {
	@Autowired
	private Mapper11 mapper;

	@GetMapping("sub01")
	public void method(
			@RequestParam(name="id",defaultValue = "0") int id,
			Model model) {
		// 1. 수정하기 전 고객정보 얻기
		JavaBean18 customer = mapper.getCustomerById(id);
		// 2. 모델에 어트리뷰트로 추가하고
		model.addAttribute("customer", customer);
		// 3. forward
		
	}
	
	@PostMapping("sub01")
	public String method(JavaBean18 customer, RedirectAttributes rttr) {
		// 1. 파라미터 수집
		
		// 2. 비지니스 로직 처리
		int cnt = mapper.updateCustomer(customer);
		System.out.println(cnt + "개 고객 정보 수정됨");
		
		// 3. 어트리뷰트 추가
		rttr.addAttribute("id", customer.getId());
		
		// 4. 리다이렉트
		return "redirect:/ex37/sub01";
	}
	
	
	
	
	// 서블릿이 요청받기 전 먼저 실행되는 객체 필터.
	// 필터가 리퀘스트파라미터의 인코딩을 바꿔주도록하면됨.
	// 그런데 이미 객체가 있어서? xml작성 또는 어노테이션을 붇임
	
	//공급자 조회 후 어트리뷰트에 담아서 포워드.
	// 
	
	
	@GetMapping("sub02")
	public void method2(
			@RequestParam(name="id",defaultValue = "0") int id, 
			//int타입은 널이 안받아져서 기본값 준거고, Integer타입은 널 받아짐.
			Model model) { //목록에 이미 있는 모델.
		// 1. 수정하기 전 고객정보 얻기
		JavaBean19 supplier = mapper.getSupplierById(id);
		// 2. 모델에 어트리뷰트로 추가하고
		model.addAttribute("supplier", supplier);
		// 3. forward
		
	}
	
	@PostMapping("sub02")
	public String method2(JavaBean19 supplier, RedirectAttributes rttr) {
		// 1. 파라미터 수집
		
		// 2. 비지니스 로직 처리
		int cnt = mapper.updateSupplier	(supplier);
		System.out.println(cnt + "개 공급자 정보 수정됨");
		
		// 3. 어트리뷰트 추가
		rttr.addAttribute("id", supplier.getId());
		
		// 4. 리다이렉트
		return "redirect:/ex37/sub02";
	}
}

//이클립스(?) 업데이트가 안될때는 메이븐 업데이트해준다.







