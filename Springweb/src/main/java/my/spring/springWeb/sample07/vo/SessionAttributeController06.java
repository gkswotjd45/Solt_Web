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
@RequestMapping(value="/sessionAttributesTest06")
public class SessionAttributeController06 {

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
	
	// 핸들러가 실행되기 전에 미리 생성해야 함
	@ModelAttribute("newStudent")
	public Student createString3(Model model) {

		Student student = new Student();
		
		return student;
	}
	
	// 
	//문제 
	
	//@Controller 모델과 세션에 같이 저장시킴  SessionAttributes(data1, shin, newStudent) 명시되어 있음
	// 핸들러의 인자를 봤더니..
	// @ModelAttributes ("newStudent") Student studentVO4가 있음..
	// 그러면 command 객체를 생성하는 것이 아니라, session에서 new Student 키값으로 저장되어있는 객체를 찾아서 인자로 주입해요.
	
	// 따라서 이 코드가 오류가 안날려면.. 당연히 session에 newStudnet "키값으로 저장되어 있는 객체가 있어야 함"
	// 정확히 얘기하면 newStudent 이 키가  session에 존재해야 함
	
	
	// 처음 들어오면 당연히 session에 해당 키값이 존재하지 않아요.
	// 코드 오류를 피하려면 @ModelAttributes annotation을 메서드위에 붙이고 리턴으로  빈 command 객체를 생성해서 모델에 저장.
	// 당연히 세션에 같이 저장될 거예요.
	// 그런다음 핸들러가 호출되기때문에 오류 피할수 있게 됨.
	
	// 핸들러는 command 객체를 생성하지 않겠죠.. 그리고 클라이언트가 보내준 데이터를 setter를 통해서 command 객체에 데이터를 삽입함.
	
	//-------------------------------------------------------------------------------------------------------
	
	
	// 따라서 클라이언트가 보내준 데이터는 핸들러가 생성되기 이전에 모델에 빈객체가 생성되고 해당 빈 객체에 
	// 1.@ModelAttributes ("newStudent") Student studentVO에 오류가 안날려면
	// session에 new Student 키 값이 았어야 함 그런데 처음들어오염 당연히 없어요.
	
	
	//현재 인자의 모델 attribute의 key값은 먼저 request의 값을 땡기기 이전의 session의 값을 일단은 땡기지만 shin은 null 값을 임.
	// 일단 세션에 값을 넣어야 하니 
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1, 
			@ModelAttribute("data2") String str2, @RequestParam(value="msg") String requestMsg
			,@ModelAttribute("newStudent") Student studentVO) {
		// 커맨드 객체로 넘겨오는 studentVO을 model newStudent을 받아옴.
		log.debug("handler() 에서 출력 :" + str1 + ", " + str2);
		log.debug("msg : " +requestMsg);
		log.debug("Student :" + studentVO);
		
		
		return "sample07/sessionResult06";
	}

}
