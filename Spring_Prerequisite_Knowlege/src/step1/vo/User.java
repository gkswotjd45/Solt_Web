package step1.vo;

//"JavaBeans 라는 규약"이 있음. 
// class를 작성하는 규칙.
// 3가지 정도 기억
// 1. 인자가 없는 기본 생성자가 존재해야 함.
// 2. field는 private으로 설정함.
// 3. getter와 setter가 존재해야 하고  public 으로 설정되어야 함.

public class User {
	
	private String id; 
	private String password;
	private String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
