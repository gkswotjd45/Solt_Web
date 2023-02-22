package springIoc.sample7;

public class Engineeer {
	private Emp emp; // 상속을 받지 않고 필드로 선언 // 상속받지않고 property 주입받아서 사용하기를 권장.
	private String dept; 
	
	public Engineeer() {
		
	}
	
	public Engineeer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
}
