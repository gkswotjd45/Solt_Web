package springIoc.anno.Sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",Emp.class);
		
		System.out.println("실질적인 contxt 이후 실행");
		Engineer obj = context.getBean("myEnginner",Engineer.class);
		
		System.out.println(obj);
		((ClassPathXmlApplicationContext)context).close();	
		
	}
}
