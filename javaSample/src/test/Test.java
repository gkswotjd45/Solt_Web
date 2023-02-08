package test;

class MyClass{

	
	// 1.생성자
	public MyClass() {
		// TODO Auto-generated constructor stub
	}
	
	// 2. 필드 (private)
	private int cost;
	
	// 3. 메서드 (method) 
	
	
	
	// 4. getter & setter => 필드가 private로 설정되어 있어 필드에 대한 접근할 수 있도록함.
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}


public class Test {
	
	public static void main(String[] args) {
		
		MyClass obj = new MyClass();
		
		// 객체의 method를 이용해 객체의 field(데이터)를 제어함.
		obj.setCost(100); // state pool = 상태가 있다. => 객체의 데이터를 필드에 박아서 저장됨. => 필드의 정보를 게속해서 유지하는 형태
		//state pool은 객체가 가지고 있는 정보를 instance field에 직접 저장ㄷ하는 방식을 지칭.
		
		// stateless = 무상태. => 상태(정보. 데이터)를 인스턴스가 가지고 있지 않음 => 필드의 특정 정보를 가지고 있지 않음. 
		// 인스턴스 필드를 사용하지 않음. => "서블릿의 방식" (특성을 이해)
		
	}
}
