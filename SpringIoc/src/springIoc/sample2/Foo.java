package springIoc.sample2;

public class Foo {

	public Foo() {
		System.out.println("foo의 기본생성자 호출");
	}
	public Foo(String str) {
		System.out.println("foo의 생성자 호출  :" + str);
	}
	
	public Foo(String str, int num) {
		System.out.println("foo의 생성자 호출  :" + str + ","+ num );
	}
	// 우리가 흔히 인젝션이라 불리는 것을 dependency 넣는 것을 특히 유념에서 봐야함. (foo 클래스는 bar 클래스에 의존형태) => bar가 있어야 foo 존재.
	public Foo(Bar bar) {
		System.out.println("foo의 생성자 호출 : " + bar);
	}
}
