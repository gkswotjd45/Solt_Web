package my.spring.springWeb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springWeb.sample07.vo.Student;

//SessionAttributes은 해당 컨트롤러 단에서만  수행하는 형태임. 
@Controller
@SessionAttributes({"data1"})
@RequestMapping(value="/sessionAttributesTest02")
public class SessionAttributeController02 {
	
	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출 됨
	// data1이라는 key로 메서드의 리턴값이 model에 저장.
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요.");
		
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(HttpServletRequest request) {
		//session을 집접 이용해 보와요.
		// true의 의미는 session이 없으면 만들고, 만들고 reference를 가져오고 => 있으면 reference만 가져옴
		
		// 이 방식은 굉장히 범용적 형태로 코드를 
		HttpSession session = request.getSession(true);
		
		Student student = new Student(30,"신사임당","국어국문");
		session.setAttribute("shin", student);
		
		
		log.debug("createString2() 호출되었어요.");
		
		return "createString1";
	}
	
	
	// handler가 처리하는 메서드 
	//post방식으로 들어오는 메서드를 수행.
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1, 
			@ModelAttribute("data2") String str2, @RequestParam(value="msg") String requestMsg
			,@ModelAttribute("newStudent") Student studentVO ,Model model) {
		// 커맨드 객체로 넘겨오는 studentVO을 model newStudent을 받아옴.
		log.debug("handler() 에서 출력 :" + str1 + ", " + str2);
		log.debug("msg : " +requestMsg);
		log.debug("Student :" + studentVO);
		
		model.addAttribute("myKey", "흐흐흐");
		
		return "sample07/sessionResult02";
	}

}
