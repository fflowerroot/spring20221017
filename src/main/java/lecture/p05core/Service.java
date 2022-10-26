package lecture.p05core;

import lombok.Data;

@Data
public class Service {

	private Repository repository; 
// 설정파일에서 Service클래스에  Repository타입의 repository프로퍼티를 주입해줬다는 뜻은
	// 뷰파일에서의 프로퍼티를 말하는 건가?????!
	
}
