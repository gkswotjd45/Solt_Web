package springIoc.anno.Sample2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// bean으로 잡음
@Component("myEnginner")
public class Engineer {
	
	@Autowired
	@Qualifier(value="emp1") //이 방식을 더 선호함.
//  OR 
//	@Resource(name="emp1") 
	private Emp emp;
	
	private String dept; // 부서정보
	
	@Autowired 
	public Engineer() {
		System.out.println("인자가 없는 Enginner 기본생성자");
	}
	
	
	
	//일반 메서드를 자도 주입할 때 , 인자 "dept" bean id를 주입. => bean type String 타입. 
	@Autowired
	public void my_dept(String dept) {
		// 하는일 은 setter 이지만, 일반 메서드. 선언.
		this.dept = dept;
		System.out.println("일반 메서드 ");
	}



	@Override
	public String toString() {
		return "Engineer 클래스의 toString() [emp=" + emp + ", dept=" + dept + "]";
	}
}
