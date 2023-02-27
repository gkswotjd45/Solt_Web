package my.spring.springWeb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springWeb.sample05.vo.User;

@Controller
public class ModelAttributesController {	
	Logger log = LogManager.getLogger("case3");
	
	// @ModelAttribute 메서드에 붙이는 방법.
	// @ModelAttribute를 지정할때는 이름을 하나 명시해야 함. // 이 method는 handler가 호출되기 이전에 자동으로 호출되요.
	// 그리고 해당 메서드의 리턴값이 model에 자동으로 등록 됨.
	
	// 모델을 호출하지 않아도 v1 모델이 자동으로 저장. ("modelAttributes1") 호출되지 않아도 model에 v1이 자동으로 들어가 있ㅇ므. v1 키값으로 모델에 저장,
	@ModelAttribute("v1")
	public String createString() {
		log.debug("문자열 객체 생성"); // 이 메소드가 먼저 호출 됨
		return "이것은 소리없는 아우성";
	}
	// v1과 v2는 무작위로 수ㅐㅇ/
	@ModelAttribute("v2")
	public User createUser() {
		log.debug("VO 객체 생성"); // 이 메소드가 먼저 호출 됨
		User user = new User(25,"홍길동", "철학과");
		return user;
	}
	// 핸들러 호출하기 전에 저장 및 수행.
	@ModelAttribute("data1")
	public int createNumber1() {
		log.debug("첫번째 숫자 생성"); // 이 메소드가 먼저 호출 됨
		log.debug("첫번째 숫자 생성");
		return 100;
	}
	
	@ModelAttribute("data2")
	public int createNumber2() {
		log.debug("두번째 숫자 생성"); // 이 메소드가 먼저 호출 됨
		log.debug("두번째 숫자 생성");
		return 200;
	}
	
	

	// 뒤에 request가 명시되지 않고, url이 나옴 => get 방식.
	// 이 아래가 핸들러.(클라이언트의 리퀘스터를 처리하는 메서드)
	@RequestMapping(value ="modelAttributes1")
	public String myMethod1(@ModelAttribute("data1") int num1,@ModelAttribute("data2") int num2,Model model) {
		
		log.debug("handler 호출!!");
		
		model.addAttribute("sum", num1+num2);
		
		return "sample05/modelResult";
	}
	
	
	@PostMapping(value ="modelAttributes2")
	public String myMethod2(@ModelAttribute("myUser") User user) {
		
		//이렇게 클라이언트가 보내준 데이터로 객체를 생성할 수 있음. => 커맨드 객체 (Command 객체)라고 불림. User user임. 클라이언트가 보내준 데이터를 가지고 핸들러 객체를 만들고 전달
		// 대부분은 Vo를 가지고 Command 객체를 생성.
		
	
		// 이게 사실 순서가 있음. [순서를 알아야 할 필요가 있음] "용어가 입에 붙어야 함"
		// 1. (@ModelAttribute 가 있다면) 만약  class leve(상위)위에  @sessionAttribute가 지정되어 있으면  [설명: 세션(클라이언트마다 1개씩 설정) 의 속성으로 붙음 ] 
		// (@ModelAttribute User user 이 코드는 session에서 User uesr 먼저 찾음. => 만약 있다면 갇다 박음, 
		// 현재 위에서 사용하고 있지 않아서  skip.
		// 2. User의 생성자를 찾아 호출해서 객체를 생성. => 이때, 생성자를 찾는데, public 생성자를 찾음. 만약 생성자가 여러개면, "그 중에서 인자가 가장적은 생성자를 찾음 "
		// => 따라서 일반적으 default 생성자가 선택. 
		// 생성자를 이용해서 객체를 생성함. 
		// 3. 그 다음은 setter을 이용해서 클라이언트가 보내준 데이터를 vo에 저장함.
		
		// 추가 정보) setter getter 메서드의 이름? 형태
		// 4. @modelAttribute는 model객체에 저장을 해줌. (자동으로 주입되는 것이 Model 
		// 기본적으로 class의 이름ㅇ르 앞글자 소문자를 만들어서 model에 저장함
		// 만약 내가 이름을  달리해서 저장하고 싶으면, @ModelAttribute("myUser") 이런 형식으로 이름을 변경해서 모델에 저장할 수 있음.
		// 당연히 jsp에서 myUser로 access 해야 함.
		
		 // 결론, 핸들러에 파라미터가 붙으면 이런식으로 수행.
		log.debug("handler 호출!!");

		
		return "sample05/modelResult";
	}
	
}
