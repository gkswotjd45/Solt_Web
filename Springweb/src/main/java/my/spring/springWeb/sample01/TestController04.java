package my.spring.springWeb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 일반적으로  @requstMapping은 class level에서 사용함.

@Controller
@RequestMapping(value="testController04")
public class TestController04 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);
	
	@GetMapping // annotation으로 처리  (요 url로 들어오는 방식중 get으로 수행)
	String myMethod01() {
//		logger.debug("testController04 get방식으로 호출되었어요.");
		return "sample01/testController04";
	}
	
	@GetMapping(value="/test001") // annotation으로 처리  (요 url로 들어오는 방식중 get으로 수행)
	String myMethod03() {
//		logger.debug("testController04 get방식으로 호출되었어요.");
		return "sample01/testController04";
	}
	
	
//	@GetMapping 
//	String myMethod02() {
//		logger.debug("testController04 get방식으로 호출되었어요.");
//		return "sample01/testController04";
//	}
	
}
