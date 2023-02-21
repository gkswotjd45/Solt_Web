package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

// 어플리케이션 컨텍션 역할을 수행.
public class DaoFactory {
	
	public UserDao userDao() {
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
		
		//인젝션을 수행하는 코드
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
}
