package springIoc.sample8;

public class TestBean {
	
	private DataBean data1; // 방금 만들 클래스를 객체를 필드로 받음.
	private DataBean data2;
	
	public TestBean() {
		System.out.println("TestBean default 생성자 호출.");
	}

	
	public DataBean getData1() {
		return data1;
	}

	public void setData1(DataBean data3) {
		this.data1 = data3;
		System.out.println("setData1() setter 호출");
	}

	public DataBean getData2() {
		return data2;
	}

	public void setData2(DataBean data2) {
		this.data2 = data2;
		System.out.println("setData2() setter 호출");
	}
	
	
}
