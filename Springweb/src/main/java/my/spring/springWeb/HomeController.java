package my.spring.springWeb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//@annotation의 하위클래스 이므로, is-A 관계에 의해 해당 @Controller bean 객체 의미.
@Controller //bean으로 등록 // 클라이언트 쓰레드에 의해 공유될수 있도록 하는 형태. (왜 등록하는지?_)
public class HomeController {

	//특정 log을 찍을 수 있도록 하는 형태. // 매클래스마다 들고 다녀야 함.// 첫줄에 명시해야 함. logger을 이용해 출력.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//cf) sysout 안좋은 형태, 실제로 서비스를 할때는 무조건 log 작업을 남겨나야 함.
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	// 메서드의 이름은 중요하지 않음, 컨틀로러는 클라이언트 요청을 처리하는 의미.
	// get방식이면 아래의 (특정한) 메서드가 처리함.

	@RequestMapping(value = "/", method = RequestMethod.GET)

	// handller는 모델 객체를 파라미터로 받을 수 있음. // 매개인자는 정해져 있지않아, 없어도 됨.// 따라서 나올수 인자를 application context에 의해 인젝션 됨.(주입)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale); // 로그 찍음.
		logger.debug("소리없는 아우성");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		//모델에 데이터를 넣어주는 형태. (key와 value 형태)
		// 결국의 컨트로러의 처리된 결과를  모델에 전달하여, jsp에 땡겨서 받는 형태
		// 모델에 formattedata를 인자로 담음
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

//	@RequestMapping(value = "/", method = RequestMethod.POST)
//
//	public String home1(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale); // 로그 찍음.
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//
//		return "home";
//	}
}
