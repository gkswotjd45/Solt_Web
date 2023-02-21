package step9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step9.dao.UserDao;
import step9.vo.User;



// userDAO가 정상적으로 실행되는 지 파악
public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		
		// 1. 사용자를 입력해 보아요
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
//		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
//		
//		//2. DAO 생성
//		UserDao dao = new UserDao(connectionMaker);
		
		// dao를 만들어서 담김. => dao를 통해서  이 클래스에서 수행.
		
		// dao 1개 달라고 요청.
		
		//UserDao dao = new DaoFactory().userDao();
		//ApplicationContext를 생성한 후 이 ApplicationContext에게 
		//UserDao 객체를 요청해서 빋아와서 사용할 예정. (annotation을 가지고 컨텍스트를 잡을 예정)
		// 해당 클래스의 설정정보가 담긴 DaoFactory.class을 전달.
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class); 
		
		// 컨텍스트에 bean 객체를 받아옴 ( beanId)을 받아와야 함. 
//		UserDao dao = (UserDao) context.getBean(""); // 기본적으로 object로 나와서 형변환을 해줘야 함.
		// 현재 싱글톤으로 객체를 잡았기 때문에. step7 과 다름 (싱글톤 전제 조건 private이어야 함 -> 정상적인 클래스가 아니어야 함)
		// application context는 일반클래스를 싱글톤으로 설정이 가능함.
		UserDao dao =  context.getBean("userDao",UserDao.class); // 앞의 형변환을 없애기 위해서, 전달받은 인자에 해당 class 명시.
		UserDao dao1 =  context.getBean("userDao",UserDao.class); 
		System.out.println(dao);
		System.out.println(dao1);
		
		dao.insert(user); // 예외처리를 메인에서 (VM)으로 그냥 넘김 => 원래 이렇게 하면 안 됨.
		System.out.println("사용자 등록 성공");
		
		// 4. 사용자 조회
		User result = dao.select("hong");
		System.out.println(result.getName()); // 결과값 홍길동 출력.
	
	}
}
