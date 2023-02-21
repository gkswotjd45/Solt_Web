package springIoc.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	public static void main(String[] args) {
		//ApplicationContext부터 생성해 봄.
		
		//xml 파일을 통해   ApplicationContext 잉용
		// 클래스 파일을 xml파일로 ApplicationContext 생성. // MessageBean에 같은 위치에 있는 xml 찾기
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",MessageBean.class);
		
		System.out.println("========= Ioc/ DI 컨테이너 생성========");
		
		// 싱글톤은 인 경우 이미 context안에 존재하지않은 bean을 찾아서 리턴하고,
		// prototpye 인 경우  이 시험에 bean 객체를 생성해서 리턴해요.
		MessageBean myBean = context.getBean("messageBean",MessageBean.class); //myBean.sayHello(); // 딸기 :3000ㅣ;
		
		myBean.sayHello(); // 딸기 :3000ㅣ;
		
		System.out.println(myBean);
		System.out.println(context.getBean("messageBean",MessageBean.class)); //myBean.sayHello(); // 딸기 :3000ㅣ;
		(( ClassPathXmlApplicationContext)context).close();
	}
	
}
