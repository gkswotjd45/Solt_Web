package step6;

import java.sql.Connection;

import step6.dao.ConnectionMaker;
import step6.dao.SimpleMakeConnection;
import step6.dao.UserDao;
import step6.vo.User;

// userDAO가 정상적으로 실행되는 지 파악
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		
		// 1. 사용자를 입력해 보아요
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
		ConnectionMaker connectionMaker = new SimpleMakeConnection();
		
		//2. DAO 생성
		UserDao dao = new UserDao(connectionMaker);
		
		dao.insert(user); // 예외처리를 메인에서 (VM)으로 그냥 넘김 => 원래 이렇게 하면 안 됨.
		System.out.println("사용자 등록 성공");
		
		// 4. 사용자 조회
		User result = dao.select("hong");
		System.out.println(result.getName()); // 결과값 홍길동 출력.
	
	}
}
