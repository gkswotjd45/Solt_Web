package step7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step7.vo.User;



// Database처리하는 코드
// 2개의 method를 작성할꺼예요!
// 사용자 입력, 조회
public class UserDao {
	
	// 인터페이스 이름을 따와서 해당 클래스 ㅡ객체  생성.
	// 해당 메서드는 해당 클래스에서만 사용될 예정 private 
	 ConnectionMaker connectionMaker; // 인터페이스 이름만 나음. 
	// 확장성을 나타내기 위해 클래스를 생성하여 호출,
	// 인터페이스 간의 연결고리만 남김.
	 
	 
	 
	// "Injection"이 발생한 형태.
	// Injection은 일반적으로 2가지 형태
	// 1. 생성자를 통한 주입  [더 선호]
	// 2. setter을 통해 주입이 있음. [xml에서 선호]
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void insert(User user) throws Exception {
		
		
		Connection con = connectionMaker.getConnection(); // 커낵션 메서드를 통해 호출하여 커넥션 객체를 가져옴.
		
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
		
		Connection con = connectionMaker.getConnection(); 
		
		
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
