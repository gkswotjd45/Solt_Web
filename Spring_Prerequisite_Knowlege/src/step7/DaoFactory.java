package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

public class DaoFactory {
	
	public UserDao userDao() {
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		UserDao dao = new UserDao(connectionMaker);
		
		
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
}
