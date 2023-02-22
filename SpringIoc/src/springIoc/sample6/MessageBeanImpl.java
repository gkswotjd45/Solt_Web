package springIoc.sample6;

public class MessageBeanImpl implements messageBean {
	
	private String name;
	private String phone;
	private Output output; // 이 필드에  어떤 구현체가 오느냐에 따라서 출력형태가 달라짐.
	
	public MessageBeanImpl() {
		System.out.println("messageBeanImpl default 생성자 호출");
	}

	public MessageBeanImpl(String name) {
		this.name = name;
		
		System.out.println("messageBeanImpl 생성자 호출  : " + name);
	}


	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setPhone() setter 호출");
	}

	public void setOutput(Output output) {
		this.output = output;
		System.out.println("setOutput setter 호출" );
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		// 얘가 특정 메시지를 콘솔로 찍던가 파일로  추렭.
		
		String msg  = name  + " : " + phone;
		
		//동적바인딩 개념 이해 필요.
		try {
			output.print(msg);
			System.out.println("메시지 출력 종료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
