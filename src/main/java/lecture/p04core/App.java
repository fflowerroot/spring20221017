package lecture.p04core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		String config = "/lecture/p04core/context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		Servlet s = context.getBean(Servlet.class); //왜 이렇게 객체를 생성하지?
		Dao d = context.getBean(Dao.class);
		
		Servlet s1 = new Servlet(); //이렇게 객체 생성해도 되는데 왜?
		
		System.out.println(s); // null이 아니어야함
		System.out.println(d); // null이 아니어야 함
		System.out.println(s1);
		
		System.out.println("프로그램 계속 실행"); // exception 없이 여기까지 실행
	}
}
