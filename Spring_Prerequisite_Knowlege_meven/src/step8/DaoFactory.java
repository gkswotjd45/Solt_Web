package step8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import step8.dao.ConnectionMaker;
import step8.dao.SimpleMakeConnection;
import step8.dao.UserDao;

// 어플리케이션 컨텍션 역할을 수행. // 
@Configuration // 설정정보.
public class DaoFactory {
	
	//객체를 만들어내는 메서드 1  // 메소드 이름 beanId userDao()
	@Bean
	public UserDao userDao() {
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
		
		//인젝션을 수행하는 코드
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	
	//객체를 만들어내는 메서드 2 // 메소드 이름 beanId connectionMaker
	@Bean
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
}
