package my.spring.springWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController02")
public class TestController02 {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController02.class);
	
	@RequestMapping("/info")
	String myMethod01() {
		logger.debug("/testController02/info 호출");
		return "sample01/testController02";
	}
	
	
	@RequestMapping("/profile")
	String myMethod02() {
		logger.debug("/testController02/profile 호출");
		return "sample01/testController02";
		}
		
	// 여러 url을 배열로 사용할 수 있음. //test03로 나오는 어떤 것이든지 url을 나타냄. (특정 url 하단의 url 까지 다 불러올수 있음)
	@RequestMapping(value= {"","/test01","test02","test03/*"})
	String myMethod03() {
		logger.debug("/testController02/멀티 호출");
		return "sample01/testController02";
	}
}
