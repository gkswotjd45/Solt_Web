package step1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import step1.vo.User;

// 데이터베이스를 처리하는 코드를 작성.
// 2개의 메서드를 작성할 꺼임.
// 사용자 입력 및 조회,
public class UserDao_bak {

	public void insert(User user) throws Exception {
		// 순수 pure JDBC를 이용해서 Database처리를 해봄.
		// 6단계로 처리 를 함. [기본적인 데이터 베이스 처리 방식)
		// 1. Driver Loading 
		Class.forName("com.mysql.cj.jdbc.Driver");
		// mysql에서 제공해준 드라이버를 명시.
		
		// 2. 연결해 보아요.(jdbc에 연결에 필요한 것을 작성)
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "janir3529";
		
		Connection con = DriverManager.getConnection(jdbcUrl,id,pw); // 실제 정보를 가지고 데이터베이스의 connection 객체를 가져옴.
		
		// 3. preparedStatement를 만듬.
		String sql = "INSERT INTO users VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		
		// 4. SQL구문을 실행.
		int result = pstmt.executeUpdate(); 
		
		// 5.결과처리
		if(result == 1) {
			System.out.println("정상적으로 입력됨");
		}
		
		// 6. resource 해제처리
		pstmt.close();
		con.close();
	}
	
	// id값을 가지고 User 객체를 가져옴.
	public User Select(String userId) throws Exception {
		// 순수 pure JDBC를 이용해서 Database처리를 해봄.
				// 6단계로 처리 를 함. [기본적인 데이터 베이스 처리 방식)
				// 1. Driver Loading 
				Class.forName("com.mysql.cj.jdbc.Driver");
				// mysql에서 제공해준 드라이버를 명시.
				
				// 2. 연결해 보아요.(jdbc에 연결에 필요한 것을 작성)
				String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
				String id = "root";
				String pw = "jaenir3529";
				
				Connection con = DriverManager.getConnection(jdbcUrl,id,pw); // 실제 정보를 가지고 데이터베이스의 connection 객체를 가져옴.
				
				// 3. preparedStatement를 만듬.
				String sql = "SELECT * FROM users where id = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,userId);
				
				// 4. SQL구문을 실행.
				ResultSet result = pstmt.executeQuery(); 
				
				// 5.결과처리
				result.next();
				User user = new User();
				user.setId(result.getString("id"));
				user.setPassword(result.getString("password"));
				user.setName(result.getString("name"));
				
				
				// 6. resource 해제처리
				pstmt.close();
				con.close();
				
				return user;
	}
	
}
