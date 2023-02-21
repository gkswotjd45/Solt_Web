package springIoc.sample3;

public class UserServiceImpl implements UserService {

	// 원래 필드가 있으면 한됨
	private User user; // vo을 서비스를 잡고있지만 vo stateless 형태여야 함.ㄴ

	public UserServiceImpl() {
		System.out.println("UserServiceImpl 기본생성자");
	}
	
	public UserServiceImpl(User user) {
		this.user = user;
		System.out.println("UserServiceImpl 생성자 호출- "+ user);
	}
	
	@Override
	public void add(User user) {
		// 일반적인 비즈니스 로직을 처리가 됨.
		System.out.println("UserServiceImpl- addUser() 메서드 호츨 ");

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
