package step7.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// 구현정보, 단일 상속의 문제를 해결(인터페이스)
public class SimpleMakeConnection  implements ConnectionMaker{
	
	
	@Override
	public Connection getConnection() throws Exception{
		// pure JDBC를 이용해서 Database처리를 해 보아요!
		// 6단계로 처리를 해요!
		
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 연결해보아요!
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "jaenir3529";
		
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);
		return con;
		
	}
	
}
