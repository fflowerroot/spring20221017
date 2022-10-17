package lecture.p03core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {
//		Servlet1 servlet1=new Servlet1();
//		servlet1.setProductDao(new ProductDao());
//		servlet1.doGet();
//		System.out.println("프로그램 계속 진행");
		
		String configLogation="/lecture/p03core/context.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(configLogation);
		
		System.out.println(context.getBean(Servlet1.class));
		System.out.println(context.getBean(ProductDao.class));
		System.out.println("프로그램 계속 실행");
	
		
	}
}
