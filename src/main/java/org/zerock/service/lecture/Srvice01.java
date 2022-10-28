package org.zerock.service.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.mapper.lecture.Mapper11;

//@Component//자동으로 인스턴스생성
@Service // 컴포넌트 포함함
public class Srvice01 {
//지금 우리 프로젝트에서 어플리케이션컨텍스트 2개임
//컴포넌트 붙으면 스캔하도록 xmml에서 설정.
	
	@Autowired
	private Mapper11 mapper;

	public JavaBean18 getCustomer(int id) {
		// 비지니스 로직
		return mapper.getCustomerById(id);
	}
	
	public void transferMoney() {
		// 1번고객의 돈을 (500원)
		// 2번 고객에게 전달
		int cnt = mapper.updateBank(1, -500);
		System.out.println(cnt + "건 성공");
	//	int a = 3/0;
		
		mapper.updateBank(2, 500);
	}
}
