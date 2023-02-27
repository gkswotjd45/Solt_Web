package my.spring.springWeb.sample02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 클래스 // request 매핑에 의해 핸들러로 사용.
@Controller
public class JSTLExampleController {

//	@RequestMapping(value = "/sample02/jstlExample")
//	//return void 이면 /jstlExample 이라는 jsp파일 생성 => view 객체 생성.
//	public void myMethod() {
//		
//	}
	
	@RequestMapping(value = "/jstlExample")
	//return void 이면 /jstlExample 이라는 jsp파일 생성 => view 객체 생성.
	public String myMethod(Model model) {
		
		List<String> list = new ArrayList<String>(); 
		list.add("홍길동");
		list.add("신사임당");
		list.add("강감찬");
		
		// 모델안에 키는 myNum myList가 있고 
		model.addAttribute("myNum",100);
		model.addAttribute("myList", list);
		
		return "/sample02/jstlExample"; // 문자열 리턴을 해당 문자열에 대한 경로에 jsp 생성 및  view 객체 생성.
		//해당 jsp 안에 if문, jstl등을 수행.
	}
	
}
