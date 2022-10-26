package lecture.p04core;

import lombok.Getter;

import lombok.Setter;

public class Servlet {
	@Setter
	@Getter
		private Dao dao;
}
//cf) 필드 값을 주입? 받는방법 .
//     	1. 생성자
//      2. set메서드