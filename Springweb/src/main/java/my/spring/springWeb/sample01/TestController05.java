package my.spring.springWeb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/testController05")
public class TestController05 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);
	
	
	// 파라미터 값이 없어도 호출이 가능. 
	
	
	
	// 파라미터 겂이 myName이 있으면,
	@GetMapping(params = "myName")
	String myMethod1() {
//		logger.debug("testController05 호출! myName");
		
		return "sample01/testController05";
	}
	
	// key와 value 값이 myName=신사임당인 경우 호출 // 위의 호출과 같이 출력할 것 같지만 더 명확한 메서드만 호출.
	@GetMapping(params = "myName=신사임당")
	String myMethod2() {
//		logger.debug("testController05 호출! myName = 신사임당");
		
		return "sample01/testController05";
	}
}
