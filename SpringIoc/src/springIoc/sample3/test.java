package springIoc.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		
		//Application Context 객체를 생성 => Spring IoC Container 생성!
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",User.class);
		
		UserService service = context.getBean("userService", UserService.class);
		
		User user = context.getBean("obj1", User.class);
		service.add(user);
		
		((ClassPathXmlApplicationContext)context).close();

	}
}
