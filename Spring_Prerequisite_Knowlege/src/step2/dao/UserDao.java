package step2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step2.vo.User;


// Database처리하는 코드
// 2개의 method를 작성할꺼예요!
// 사용자 입력, 조회
public class UserDao {
	
	// 해당 메서드는 해당 클래스에서만 사용될 예정 private 
	private Connection getConnection() throws Exception{
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
	
	
	public void insert(User user) throws Exception {
		

		Connection con = getConnection(); // 커낵션 메서드를 통해 호출하여 커넥션 객체를 가져옴.
		
		// 3. PreparedStatemenet를 만들어요!
		String sql = "INSERT INTO users VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		
		// 4. SQL구문 실행
		int result = pstmt.executeUpdate();
		
		// 5. 결과처리
		if(result == 1) {
			System.out.println("정상적으로 입력되었어요!");
		}
		
		// 6. resource 해제
		pstmt.close();
		con.close();
	}
	
	public User select(String userId) throws Exception {
		
		Connection con = getConnection(); 
		
		
		// 3. PreparedStatemenet를 만들어요!
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		// 4. SQL구문 실행
		ResultSet result = pstmt.executeQuery();
		
		// 5. 결과처리
		result.next();
		User user = new User();
		user.setId(result.getString("id"));
		user.setPassword(result.getString("password"));
		user.setName(result.getString("name"));
		
		// 6. resource 해제
		pstmt.close();
		con.close();
		
		return user;
	}
	
}
