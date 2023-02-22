package springIoc.sample7;

// 상속관계에 해당 되서 서로 강결합되어 있음. 이 방식으로 쓰지 않도록 권고 사항.
public class Developer extends Emp {
	
	private String dept; // 부서 필드

	public Developer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Developer(String name, int salary, String dept) {
		super(name,salary); // 상위클래스 필드를 호출함.
		this.dept = dept;
	}
}
