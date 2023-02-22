package springIoc.sample6;

// 콘솔에서 출력하는 클래스.
public class ConsoleOutput implements Output {
	
	// 메시지가 있으면 콘솔에 출력 (sysout 출력)
	
	// 기본 생성자.
	public ConsoleOutput() {
		System.out.println("ConsoleOutPut default 생성자 호출.");
	}
	

	@Override
	public void print(String message) throws Exception {
		System.out.println(message);
	}
	
}
