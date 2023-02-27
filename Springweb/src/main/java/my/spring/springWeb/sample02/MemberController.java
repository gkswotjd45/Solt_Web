package my.spring.springWeb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springWeb.sample02.vo.Member;

@Controller
public class MemberController {
//	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	// post방식으로 request를 전달 받음.
	@PostMapping(value = "member1")
	// 어떤 이름으로 값을 받아올지 작성  //primitive type String으로 받음.
	public ModelAndView myMethod1(@RequestParam(value = "Name", defaultValue = "없음") String name,
			@RequestParam(value = "Phone", defaultValue = "없음") String phone, String id,
			@RequestParam(value = "password", defaultValue = "없음") String password,Model model
	// requestparam으로 받아오는 key가 name 이고, 받아 온 값을 String으로 받음.
	) {
		ModelAndView mav = new ModelAndView(); // 모델객체가 안들어 와서 따로 선언.
//		mav.addObject("name", name);
//		mav.addObject("id", id);
//		mav.addObject("phone", phone);
//		mav.addObject("password", password); // 모델앤 뷰에 객체를 붙여주면 => model객체가 아닌 request에 붙여짐

		
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		
		mav.setViewName("sample02/memberView"); // 나중에 사용할 jsp를 명시.
		return mav; // 해당 mav에 디스패처에 가서 viewResevler에 가서 해당 jsp를 찾음.
	}

	// post방식으로 request를 전달 받음.
	@PostMapping(value = "member2")
	//member라는 객체를 만들어서 해당 vo 필드의 값을 찾아서 대입을 함.
//	public ModelAndView myMethod2(Member vo) {}
	// vo는 @ModelAttribute 사용.
	public ModelAndView myMethod2(@ModelAttribute Member vo) {

//		logger.debug(vo.toString()); //정말로 클라이언트가 보내준 데이터가 VO로 생성되었는지 확인이 가능 (클라이언크가 보내준 vo가 이렇게 받는지 확인)
		
		ModelAndView mav = new ModelAndView(); // 모델객체가 안들어 와서 따로 선언.
		mav.addObject("memberVO", vo);

		mav.setViewName("sample02/memberView"); // 나중에 사용할 jsp를 명시.
		return mav; // 해당 mav에 디스패처에 가서 viewResevler에 가서 해당 jsp를 찾음.

	}
	@PostMapping(value = "member3")
	//member라는 객체를 만들어서 해당 vo 필드의 값을 찾아서 대입을 함.
//		public String myMethod3(@ModelAttribute Member vo) 
	
	public String myMethod3(@ModelAttribute (value="mem") Member vo) { 
		//@ModelAttribute 클라잉너트가 vo를 만들고 model에 => ModelAttribute에 밀어 넣음 =>  자동으로 들어감 (ModelAttribute)) 그럼 key 값은 기본적으로 member
		// 이지만, 임의로 key mem으로 변경.
//		logger.debug(vo.toString()); //정말로 클라이언트가 보내준 데이터가 VO로 생성되었는지 확인이 가능 (클라이언크가 보내준 vo가 이렇게 받는지 확인)
		
		
		return "sample02/memberView"; // 해당 mav에 디스패처에 가서 viewResevler에 가서 해당 jsp를 찾음.

	}
	
	@PostMapping(value = "member4")

	public String myMethod4(Member vo, @RequestParam String address) { 
		//@ModelAttribute 클라잉너트가 vo를 만들고 model에 => ModelAttribute에 밀어 넣음 =>  자동으로 들어감 (ModelAttribute)) 그럼 key 값은 member
//		logger.debug(vo.toString()); //정말로 클라이언트가 보내준 데이터가 VO로 생성되었는지 확인이 가능 (클라이언크가 보내준 vo가 이렇게 받는지 확인)
		
		
		return "sample02/memberView"; // 해당 mav에 디스패처에 가서 viewResevler에 가서 해당 jsp를 찾음.

	}
}
