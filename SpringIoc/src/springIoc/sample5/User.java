package springIoc.sample5;

public class User {
	private String name;
	private String birth;
	
	public User() {
		System.out.println("default 생성자");
	}
	
	public User(String name, String birth) {
		super();
		this.name = name;
		this.birth = birth;
		System.out.println("생성자" + name + "," + birth);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
		System.out.println("set메서드" + name );
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		
		this.birth = birth;
		System.out.println("set메서드" + birth);
	}
	
	@Override
	public String toString() {
	
		return name + "의 생일은 "  + birth;
	}
}
