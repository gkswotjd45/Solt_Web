package my.spring.springWeb.sample01;

// 해당 로거 인터페이스를 이용
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller로 쓰일 예정 // 해당 클래스를 컨트롤러로 쓰임
@Controller
public class testController01 {
	
	// 필드를 직접적으로 access 필드를 선언함 // 로그 객체를 통해 로그를 작성 (팩토리에서 로그를 가져옴) // 파라미터를 문자열 형태는 아님.
	private static final Logger logger = LoggerFactory.getLogger(testController01.class);
	
	// request 매핑설정만 잘 하면 됨 // 이런  url이 들어오면 해당 request mapping을 처리 
	// http://localhost:8080/springwb/testController01 이렇게 들어오면 핸들러가 수행.
	@RequestMapping(value="/testController01", method = RequestMethod.GET) // 그냥 "/ 써도 되고"  "/" 안써도 됨
	String myMethod() {
		// 핸들러로 지정 // 해당 클래스를 처리하렜다 는 의미
		 logger.debug("/springwb/testController01 호출!"); // 현재 무엇이 호출되었는지 로그로 출력함.
		 
		 return "sample01/testController01";
		
	}
	
}
