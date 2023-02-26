package my.spring.springWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// Client Request method에 따른 Handler 호출!
// RequestMethod.GET , RequestMethod.POST 

@Controller
@RequestMapping(value="/testController03")
public class TestController03 {
	// 해당 클래스에서 발생하는 로그를 알수 있도록 클래스를 지정.
	private static final Logger logger = LoggerFactory.getLogger(TestController03.class);
	
	
	// 똑같은 url 지만 메서드 방식을 다르게 받는 형태.
	
	@RequestMapping(value="",method = RequestMethod.GET)
	String myMethod1() {
		return null;
	}
	
	@RequestMapping(value="",method = RequestMethod.POST)
	String myMethod2() {
		return null;
	}
	
}
