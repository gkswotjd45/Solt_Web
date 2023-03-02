package my.spring.springWeb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// 인터페이스를 구현한 클래스를 만들고, 이를 직접 구현한 bean을 만들 수 있음.
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext ctx;
	
	// ctx을 얻기 위해 get메서드를 이용해서 수행.
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	// 이 인터페이스를 사용하려면 해당 메서드를 오버라이딩 해야함.
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 이 메서드 역할은 이 인자로 들어온 얘가 Spring 관련 context 임 = applicationContext
		this.ctx = applicationContext;
	}
	
}
