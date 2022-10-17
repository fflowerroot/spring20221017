package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
//@AllArgsConstructor // 모든 필드를 argument로 받는 생성자 생성
//@NoArgsConstructor// argument가 없는 생성자 생성
//@RequiredArgsConstructor // 초기화가 필요한 final필드를 argument로 갖는 생성자 생성. ( final 필드가 없는 경우는 기본생성자 생성해줌)
public class JavaBean7 {
	
	private final String name;
	private final int age;
	
//	JavaBean7(String name, int age){
//		this.name=name;
//		this.age = age;
//	}
	
}
