package springIoc.anno.Sample2;


// VO 파일
public class Emp {
	
	private String name;
	private int age;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}


	// 필드의 정보를 출력하는 식으로 수행.
	@Override
	public String toString() {
		return name + ", " + age;
	}
	
}
