package step9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import step9.dao.ConnectionMaker;
import step9.dao.SimpleMakeConnection;
import step9.dao.UserDao;


// 어플리케이션 컨텍션 역할을 수행. // 
@Configuration
public class DaoFactory {
	
	//객체를 만들어내는 메서드 1  // 메소드 이름 beanId userDao()
	@Bean
	public UserDao userDao() {
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
		
		//인젝션을 수행하는 코드
						// 생성자에 객체를 넣어서 수행하는 방법.
//		UserDao dao = new UserDao(connectionMaker());
		
		
		//setter 방식으롤 활용한 메서드
		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		return dao;
	}
	
	//객체를 만들어내는 메서드 2 // 메소드 이름 beanId connectionMaker
	@Bean
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
		// 이걸 만드는 패키지 이름. = bean class SimpleMakeConnection
	}
}
