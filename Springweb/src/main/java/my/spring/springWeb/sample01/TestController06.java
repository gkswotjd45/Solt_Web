package my.spring.springWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping(value="testController06")
public class TestController06 {

	private static final Logger logger = LoggerFactory.getLogger(TestController06.class);
	
	// 이거 진짜로 Bean이 생성되는 건가요??
	public TestController06() {
		logger.debug("TestController06 Bean 생성");
	}
	
	@GetMapping
	public ModelAndView showStaticView() {
		
		logger.debug("testController06 호출");
		
		// 경로를 줄 때 html일 경우 webapp 하단부터 절대경로를 이용하면 편하다. /를 써주면 절대경로다.
		InternalResourceView view = new InternalResourceView("/resources/sample01/06.html"); // 내가 어떤 파일을 가지고 만들건지 ()안에 인자로 넣어줘야된다. 
		
		ModelAndView mav = new ModelAndView(view);
		
		return mav;
		
	}
}
