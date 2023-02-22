package springIoc.sample6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		// Application Context를 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml",Output.class);
		
		messageBean bean = context.getBean("myBean",messageBean.class);
		// bean 객체를 가져와서 Message Bean 객체로 가져옴.
		
		bean.sayHello(); // 설정에 따라 console에 출력할수도 있고 파일에 출력할 수 도 있음.
		
		
		messageBean bean_1 = context.getBean("myBeanConsole",messageBean.class);
		
		bean_1.sayHello();
		
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
