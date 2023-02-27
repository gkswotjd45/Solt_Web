package my.spring.springWeb.sample03;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logTestController {
	Logger log = LogManager.getLogger("case3"); // 콘솔 및 파일에도 출력.
		
	@RequestMapping(value = "log1")
	public String myMethod1() {
		log.debug("소리없는 아우성"); 
		
		return "sample03/logview";
	} 
}
