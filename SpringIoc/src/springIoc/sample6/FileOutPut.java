package springIoc.sample6;

import java.io.FileWriter;

public class FileOutPut implements Output {
	
	
	private String filePath;
	
	
	// 인젝션 주입방식  1. 생성자 이용
	// 기본생성자를 사전에 명시
	public FileOutPut(){
		System.out.println("Fileout default 생성자 명시");
	}
	

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public FileOutPut(String filePath) {
		super();
		this.filePath = filePath;
		// 생성자에 문자열을 주입하여 수행하는 생성자임.
		System.out.println("FileOutput 생성자 호출 : -" + filePath);
	}
	
	@Override
	public void print(String message) throws Exception {
		// 인터페이스를 구현하기 위해서 해당 클래스에서 메서드를 오버라이딩 (재정의)
		
		//1. 파일 경로를 명시 => 특정파일을 출력해보겠다는 의미.
		// 스트림을 열기. (해당 파일 경로을 가지고 통로 생성)
		FileWriter out = new FileWriter(filePath);
		
		//파일을 특정 문자열을 저장.
		out.write(message);
		
		out.close(); 
		
		System.out.println("FileOutPut 객체의 print() method 호출!");
		
	}

	
}
