package springIoc.sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",DataBean.class);
		//application context가 만들어지면 자동적으로 bean이 수행.
		
		
//		TestBean bean = (TestBean) context.getBean("myObj");
		TestBean bean = context.getBean("myObj",TestBean.class);
		
		//auto-wire
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());
	}
}
