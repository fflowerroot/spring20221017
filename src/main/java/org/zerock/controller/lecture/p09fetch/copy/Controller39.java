package org.zerock.controller.lecture.p09fetch.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.service.lecture.Srvice01;

@Controller
@RequestMapping("ex39")

public class Controller39 {

	@Autowired
	private Srvice01 service;
	// 보통 하나의 서비스가 하나의 트랜젝션(하나의 업무)
	// 마이바티스가 커넥션하고있는데 어떻게 건드릴 수 있는지
	// 이 메서드를 감사는 가상의 메서드 만들기

	// ajax : asynchoronous(비동기) javascript and xml
	// "Asynchronous JavaScript and XML") is a set of web development techniques
	// that uses various web technologies on the client-side to create asynchronous
	// web applications.
	// ajax이용해서 댓글처리함
	// ajax를 사용하는 여러 라이브러리들이 생겨났음.
	// 웹표준을 정하면서 라이브러리를 사용하지 않고도 쓸 수 있게 그냥 브라우저에? 넣어놓음.
	// 책에서는 jquery라이브러리 사용함.
	// 우리는 브라우저가 기본제공해주는 fetch 사용
	// ajax가 있기 전에는 요청에 대한 응답으로 페이지 전체가 로딩됨(페이지 전체가 깜박거림)
	// ---> 링크를 클릭했을 때 페이지 전체가 새로고침되어서 로딩됨 (바뀔 필요가 없는 부분까지 다시 로딩됨)

	// ? 유독 댓글을 비동기로 처리해야하는 이유는 ?

	// ---------------Fetch API---------------
	// Fetch API는 리소스를 가져오기 위한 인터페이스를 제공합니다(네트워크 전체 포함).
	// XMLHttpRequest를 사용해 본 사람이라면 누구에게나 친숙하게 보일 것이지만 새로운 API는 더 강력하고 유연한 기능 세트를
	// 제공합니다.

	// ---------XMLHttpRequest(XHR) API--------
	// XMLHttpRequest(XHR) 개체는 서버와 상호 작용하는 데 사용됩니다.
	// 전체 페이지를 새로 고칠 필요 없이 URL에서 데이터를 검색할 수 있습니다.
	// --> ? ? 전체 페이지를 새로 고칠필요가 없다는게 무슨 ? --> 사용자가 브라우저 새로고침 할 필요가 없다는 말인가 ?
	// 이를 통해 웹 페이지는 사용자가 수행하는 작업을 방해하지 않고 페이지의 일부만 업데이트할 수 있습니다.
	// ---> 사용자가 수행하는 작업을 방해하지 않고가 무슨 ?

	// XMLHttpRequest는 AJAX 프로그래밍에서 많이 사용됩니다.

	// 이벤트 대상
	// XMLHttpRequestEventTarget
	// XMLHttpRequest
	// 이름에도 불구하고 XMLHttpRequest는 XML뿐만 아니라 모든 유형의 데이터를 검색하는 데 사용할 수 있습니다.

	// 통신에 서버에서 '이벤트 데이터'나 '메시지 데이터'를 수신해야 하는 경우
	// 'EventSource 인터페이스'를 통해 서버에서 보낸 이벤트를 사용하는 것이 좋습니다. 전이중 통신의 경우 WebSocket이 더 나은
	// 선택일 수 있습니다.

	@RequestMapping("sub01")
	public void method1() {
	}

	@RequestMapping("sub02")
	public void method2() {
		System.out.println("/ex39/sub02 요청 잘 받음");
	}

	// /ex39/sub03 요청 받아서 처리하는 메소드 작성
	@RequestMapping("sub03")
	public void method3() {
		System.out.println("/ex39/sub03 요청 잘 받음!!!");
	}

}















