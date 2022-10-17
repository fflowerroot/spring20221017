package lecture.p01lombok;

public class App {
	
	public static void main(String[] args) {
		JavaBean1 j1=new JavaBean1();
		JavaBean2 j2=new JavaBean2();
		String campany2=j2.getCompany();
		int score2=j2.getScore();
		
		j2.setCompany("tesla");
		JavaBean4 j4=new JavaBean4();
		
		System.out.println(j4.toString());
	}
}
