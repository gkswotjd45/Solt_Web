package my.spring.springWeb.sample01.vo;

// 일반적으로 javabean 규약 클래스를 만들 때, 해당 규칙을 이용해서 적합한 클래스로 수행해야 함.
// 1. 기본생성자 존재  2. 모든 field는 private 3. 각 field를 사용하기 위해 public 으로 되어 있는 setter, getter
// cf) 어플리케이션 콘텍스트 와 다른 bean 임.
// 이렇게 javabean 규약을 지켜서 만들 클래스의 객체 를 생성했을 때 특별히 이필드를 뭐라고 하나면 property라고 불림. 
// => field가  property임.
// VO // javaBean 객체
public class User {
	private String userName;
	private int userAge;
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String userName, int userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	
}
