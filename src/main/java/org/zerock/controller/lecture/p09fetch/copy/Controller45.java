package org.zerock.controller.lecture.p09fetch.copy;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.lecture.JavaBean24;
import org.zerock.domain.lecture.JavaBean25;
import org.zerock.domain.lecture.JavaBean26;
import org.zerock.domain.lecture.JavaBean27;

// 요청은 컨트롤러 메서드의 파라미터로 받고
// 응답은 컬트롤러 메서드의 리턴으로 한다

@Controller
@RequestMapping("ex45")
public class Controller45 {

	@RequestMapping("sub")
	public void method1() {
		// 자바스크립트가 필요해서 jsp로 포워드만하드 메서드 만듬
	}

	@GetMapping("sub01")
	public ResponseEntity m1() {
//		return ResponseEntity.badRequest().build();
		return ResponseEntity.status(5555).build();
	}

	@GetMapping("sub02")
	public ResponseEntity m2() {
//		return ResponseEntity.status(202).build();
		return ResponseEntity.accepted().build();
	}

	@GetMapping("sub03")
	public ResponseEntity m3() {
		return ResponseEntity.ok()
				.header("My-Header", "My-Value")
				.build();
	}

	@GetMapping("sub05")
	public ResponseEntity<String> m5() {
		return ResponseEntity.ok()
				.body("hello 안녕");
	}

	@GetMapping("sub06")
	public ResponseEntity<JavaBean24> m6() {
		JavaBean24 data = new JavaBean24();
		data.setLocation("Seoul");
		data.setSince("2000");
		return ResponseEntity.ok().body(data);
	}// 지금은 우리가 데이터를 만들어서 넣었지만 보통 메퍼를 통해서 DB에서 가져올 것임.

	@GetMapping("sub08")
	public ResponseEntity<JavaBean27> method08() {
		JavaBean27 data = new JavaBean27();
		data.setName("박지성");
		data.setDate(LocalDate.now());
		data.setDateTime(LocalDateTime.now());
		
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("sub09")
	public ResponseEntity<JavaBean25> method09() {
		JavaBean25 data = new JavaBean25();
		JavaBean26 sub = new JavaBean26();
		
		sub.setAddress(List.of("서울", "부산", "제주"));
		sub.setMarried(true);
		
		data.setInfo(sub);
		data.setAge(99);
//		ResponseEntity<JavaBean25> res = new ResponseEntity<JavaBean25>(HttpStatus.ACCEPTED); 
//		System.out.println(res.getBody());   //그냥써본코드
		return ResponseEntity.ok(data);
	}
		
	
	@GetMapping("sub10")
	@ResponseBody
	public JavaBean25 method10() {
		JavaBean25 data = new JavaBean25();
		JavaBean26 sub = new JavaBean26();
		
		sub.setAddress(List.of("서울", "부산", "제주"));
		sub.setMarried(true);
		
		data.setInfo(sub);
		data.setAge(99);
		
		return data;
	}
	
	// sub11 요청경로 
	// JavaBean27 을 json 으로 변경한 응답하는 메소드 작성
	// @ResponseBody 사용
	@GetMapping("sub11")
	@ResponseBody
	public JavaBean27 method11() {
		JavaBean27 data = new JavaBean27();
		data.setName("박지성");
		data.setDate(LocalDate.now());
		data.setDateTime(LocalDateTime.now());
		
		return data;
	}
	
	@GetMapping("sub12")
	@ResponseBody
	public String method12() {
		return "헬로 월드";
	}
}
	
	
	
	
	
	
	
	
//ResponseEntity<T> 타입이 String이 아니면 자동으로 제이슨?으로 변환해줌(우리가 라이브러리?추가해서)

// 헤더는 스프링이 알아서 맞춰주니까 건들일 일이 별로 없음.

//Informational responses (100 – 199)
//Successful responses (200 – 299)
//Redirection messages (300 – 399)
//Client error responses (400 – 499)
//Server error responses (500 – 599)

// ? client error랑 server error랑 뭐가 다름 ?
