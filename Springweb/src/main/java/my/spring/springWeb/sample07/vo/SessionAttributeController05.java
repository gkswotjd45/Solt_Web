package my.spring.springWeb.sample07.vo;

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

//SessionAttributes은 해당 컨트롤러 단에서만  수행하는 형태임. 
@Controller
//모델과 세션에 같이 저장시킴 (data1, shin,newStudent도  같이 저장 // 내가 모델 객체 뿐만아니라 세션에 유지 해야하는 데이터는 세션에 데이터를 저장할 수 있음.
@SessionAttributes({"data1","shin","newStudent"})
@RequestMapping(value="/sessionAttributesTest05")
public class SessionAttributeController05 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출 됨
	// data1이라는 key로 메서드의 리턴값이 model에 저장.
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요.");
		
		return "createString1"; // 모델 과 세션에 같이 저장.
	}
	
	// 모델에서는 data2을 저장. / model 객체에 저장한 shin 키는 세션에 저장.
	@ModelAttribute("data2")
	public String createString2(Model model) {

		
		Student student = new Student(30,"신사임당","국어국문");
		model.addAttribute("shin", student);
		
		log.debug("createString2() 호출되었어요.");
		
		return "createString2";
	}
	
	
	//현재 인자의 모델 attribute의 key값은 먼저 request의 값을 땡기기 이전의 session의 값을 일단은 땡기지만 shin은 null 값을 임.
	// 일단 세션에 값을 넣어야 하니 
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1, 
			@ModelAttribute("data2") String str2, @RequestParam(value="msg") String requestMsg
			,@ModelAttribute("newStudent") Student studentVO ) {
		// 커맨드 객체로 넘겨오는 studentVO을 model newStudent을 받아옴.
		log.debug("handler() 에서 출력 :" + str1 + ", " + str2);
		log.debug("msg : " +requestMsg);
		log.debug("Student :" + studentVO);
		
		
		return "sample07/sessionResult05";
	}

}
