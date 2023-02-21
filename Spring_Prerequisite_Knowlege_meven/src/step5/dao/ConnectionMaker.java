package step5.dao;

import java.sql.Connection;

// 인터페이스는 추상 메서드만 들어남.
public interface ConnectionMaker {
	
	// 나중에 커넥션을 리턴해줌.
	Connection getConnection() throws Exception;
}
