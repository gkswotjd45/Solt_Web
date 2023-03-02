package my.spring.springWeb.sample10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/rest/user")
public class MyRestController {
	Logger log = LogManager.getLogger("case3");
			
	// 이걸로 들어오는 get방식 해당 메서드 수행.
	@GetMapping
	public ResponseEntity<?> method01(String id, String name){
		log.debug("실제 get방식으로 호출되었어요.");
		log.debug(id + "," + name);
		
		
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name){
		log.debug("Delete 방식으로 호출되었어요.");
		log.debug(id + "," + name);
		return null;
	}
}
