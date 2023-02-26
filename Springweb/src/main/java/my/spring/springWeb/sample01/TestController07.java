package my.spring.springWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testController07")
public class TestController07 {
	private static final Logger logger = LoggerFactory.getLogger(TestController07.class);
	
	
	@GetMapping
	public String myMethod(Model model) {
		
		
		// 모델 객체가 주입되요 (ApplicationContext에 의해서)
		
		// 모델은 map으로 되어 있음 key:value 형태로 데이터 저장
		logger.debug("TestController07 호출되었음.");
		
		model.addAttribute("myName","홍길동");
		model.addAttribute("myAge",20);
		
	
		return "sample01/testController07"; // 결과로 jsp로 렌더링할 문자열 반환
		
		
	}
}
