package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드를 argument로 받는 생성자 생성
@NoArgsConstructor// argument가 없는 생성자 생성
//@RequiredArgsConstructor   ?
public class JavaBean6 {
	
	private String name;
	private int age;
	
}
