package my.spring.springWeb.sample08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class requestMappingConsumesController {
	
	Logger log = LogManager.getLogger("case3");
	//consumes는 배열이 옴 (여러가지 종류를 제한할 수 있는 형태이므로) => 어떤 데이터 타입만 받을지 명시하는 형태. (mine type 형태로 표현)
	@RequestMapping(value= "/testController1", method=RequestMethod.GET, consumes = {"application/json" , "application/xml" })
	public String myMethod1() {
		
		log.debug("get방식으로 호출 되었어요.");
		
		return null;
	}
	
	@RequestMapping(value= "/testController2", method=RequestMethod.POST, consumes = {"application/json" ,"application/x-www-form-urlencoded"})
	public String myMethod2() {
		
		log.debug("post방식으로 호출 되었어요.");
		
		return null;
	}
}
