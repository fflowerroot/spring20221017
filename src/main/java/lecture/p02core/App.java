package lecture.p02core;

public class App {
	public static void main(String[] args) {
		Servlet1 servlet1=new Servlet1();
		servlet1.setProductDao(new ProductDao());
		servlet1.doGet();
		System.out.println("프로그램 계속 진행");
	}
}



//빈 설정이 들어간 xml
//스프링이 할 일 1. 객체생성하는 일-----
//컴포넌트라는 어노테이션 - 어느 패키지를 스캔할건지.
//빈을 만드는 코드를 직접 작성하는 것보다 컴포넌트 어노테이션을 쓰면 편하다.
//스프링이 할 일 2. 주입하는 일--------





//
//1. Overview
//Bean is a key concept of the Spring Framework. So understanding this notion is crucial to get the hang of the framework and use it in an effective way.
//
//Unfortunately, there aren't clear answers to the simple question of what a Spring bean really is. Some explanations go to such a low level that the big picture is missed, whereas others are too vague.
//
//This tutorial will try to shed light on the topic, starting with a description in the official documentation.



//2. Bean Definition
//Here's a definition of beans in the Spring Framework documentation:
//
//In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.



//3. Inversion of Control
//Simply put, Inversion of Control (IoC) is a process in which an object defines its dependencies without creating them. This object delegates the job of constructing such dependencies to an IoC container.
//
//Let's start with the declaration of a couple of domain classes before diving into IoC.
//


//3.1. Domain Classes
//Assume we have a class declaration:
//
//public class Company {
//    private Address address;
//
//    public Company(Address address) {
//        this.address = address;
//    }
//
//    // getter, setter and other properties
//}
//Copy
//This class needs a collaborator of type Address:
//
//
//freestar
//public class Address {
//    private String street;
//    private int number;
//
//    public Address(String street, int number) {
//        this.street = street;
//        this.number = number;
//    }
//
//    // getters and setters
//}
//Copy


//3.2. Traditional Approach
//Normally, we create objects with their classes' constructors:
//
//Address address = new Address("High Street", 1000);
//Company company = new Company(address);
//
//

//
//There's nothing wrong with this approach, but wouldn't it be nice to manage the dependencies in a better way?
//
//Imagine an application with dozens or even hundreds of classes. Sometimes we want to share a single instance of a class across the whole application, other times we need a separate object for each use case, and so on.
//
//Managing such a number of objects is nothing short of a nightmare. This is where inversion of control comes to the rescue.
//
//Instead of constructing dependencies by itself, an object can retrieve its dependencies from an IoC container. All we need to do is to provide the container with appropriate configuration metadata.


//3.3. Bean Configuration
//First off, let's decorate the Company class with the @Component annotation:
//
//@Component
//public class Company {
//    // this body is the same as before
//}
//Copy
//Here's a configuration class supplying bean metadata to an IoC container:
//
//@Configuration
//@ComponentScan(basePackageClasses = Company.class)
//public class Config {
//    @Bean
//    public Address getAddress() {
//        return new Address("High Street", 1000);
//    }
//}
//Copy
//The configuration class produces a bean of type Address. It also carries the @ComponentScan annotation, which instructs the container to look for beans in the package containing the Company class.
//
//When a Spring IoC container constructs objects of those types, all the objects are called Spring beans, as they are managed by the IoC container.
//
//3.4. IoC in Action
//Since we defined beans in a configuration class, we'll need an instance of the AnnotationConfigApplicationContext class to build up a container:
//
//ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//Copy
//A quick test verifies the existence and the property values of our beans:
//
//Company company = context.getBean("company", Company.class);
//assertEquals("High Street", company.getAddress().getStreet());
//assertEquals(1000, company.getAddress().getNumber());
//Copy
//The result proves that the IoC container has created and initialized beans correctly.
//
//4. Conclusion
//This article gave a brief description of Spring beans and their relationship with an IoC container.
//
//
//freestar
//The complete source code can be found over on GitHub.