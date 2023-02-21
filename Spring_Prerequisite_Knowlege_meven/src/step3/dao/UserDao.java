package step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step3.vo.User;



// Database처리하는 코드
// 2개의 method를 작성할꺼예요!
// 사용자 입력, 조회
public abstract class UserDao  {
	
	// "추상 메서드를 선언" 따라서 => UserDAO도 "추상클래스화 됨."
	protected abstract Connection getConnection() throws Exception;
	// 패키지가 달라도 상속받을 수 있다는 protected를 사용해야 함.
	// 내 userDAO를 통해 변경될 것을 추상화 시킴.
	
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
