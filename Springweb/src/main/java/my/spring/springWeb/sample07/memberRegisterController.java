package my.spring.springWeb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springWeb.sample07.vo.Member;

@Controller
//본질적인 목적은 form1에 입력한 데이터를 세션에 저장 //memberInfo 키값임. // 먼저 세션에 있는 memberInfo을 찾음.
@SessionAttributes(value = { "memberInfo" })
public class memberRegisterController {

	Logger log = LogManager.getLogger("case3");

	//해당 메서드는  빈 커맨드 을 통해 memberInfo을 만들어서 세션에 올림
	// 처음 session의 key를 만들어 주는 역할.
	@ModelAttribute("memberInfo")
	public Member createMember() {
		// 다른 url이 왔을 때 계속 호출되지 않고 딱 최초만 호출. => 계속 초기화되지 않음 (언제 @SessionAttributes(value = { "memberInfo" }) 명시되어있을 때)
		log.debug("createMember가 호출되었어요.");
		Member member = new Member();
		return member;
	}

	@PostMapping(value = "memberRegisterStep1")
	public String handler1() {

		log.debug("handler1() 호출- 회원가입 첫 페이지 .");
		return "sample07/step01";
	}

	@PostMapping(value="memberRegisterStep2")
	// member라는 커맨드 객체를 만들고 이에 해당하는 member에 setter값을 넣음. = 이게 memberInfo
	public String handler2(@ModelAttribute("memberInfo") Member member) {
		log.debug("handler1() 호출- 회원가입 두번째  페이지 .");
		log.debug(member);
		return "sample07/step02";
	}
	
	@PostMapping(value="memberRegisterStep3")
	public String handler3(@ModelAttribute("memberInfo") Member member, SessionStatus sessionStatus) {
		log.debug("handler3() 호출- 저장기능 호출");
		log.debug(member);
		sessionStatus.setComplete();
		//sessionStatus 은 위쪽에 명시한 session에서 key를 제거함. (
		//service와 @repository를 이용해서 처리
		// redirect => sendRedirect 역할 // get방식으로 처리 함.
		return "redirect:/memberRegisterStep1";
	}
	@GetMapping(value = "memberRegisterStep1")
	public String handler4() {

		log.debug("handler4() 호출- 회원가입 첫 페이지 .");
		return "sample07/step01";
	}
}
