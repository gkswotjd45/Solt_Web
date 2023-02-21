package springIoc.sample1;

public class MessageBeanImpl implements MessageBean {

	private String fruit; // bean의 필드 과일
	private int cost;
	
	
	public MessageBeanImpl() { //기본생성자
		System.out.println(" MessageBeanImpl 기본 생성자 호출");
	}
	
	public MessageBeanImpl(String fruit) { // 필드값을 인자로 받은 생성자
		this.fruit = fruit;
		System.out.println(" MessageBeanImpl 생성자 호출  - " + fruit);
	}
	
	public MessageBeanImpl(String fruit,int cost) { // 필드값을 인자로 받은 생성자
		this.fruit = fruit;
		this.cost = cost;
		System.out.println(" MessageBeanImpl 생성자 호출  - " + fruit + ", "+ cost);
	}
	
	
	public void setCost(int cost) { // setter 메서드
		this.cost = cost;
		System.out.println(" setCost setter 호출  - " +cost);
	}

	@Override
	public void sayHello() {
		System.out.println(fruit + ", "+ cost);
		
	}

}
