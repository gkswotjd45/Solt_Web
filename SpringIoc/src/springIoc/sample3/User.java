package springIoc.sample3;

//Vo 파일 ,//  쓰지 않는 getter, setter은 굳이 만들지 않음. 
public class User {
	private String userName;
	
	public User() {
		System.out.println("User의 기본 생성자 호출");
	}

	public User(String userName) {
		super();
		this.userName = userName;
		System.out.println("Userd의 생성자 호출 :" + userName);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
