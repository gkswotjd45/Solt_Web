package my.spring.springWeb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springWeb.sample01.TestController03;

@Controller
@RequestMapping("calc.do")
public class CalcController {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController03.class);
	
	@PostMapping //위의 url을 post 방식을 받는 메서드 (처리하는 핸들러) // 첫번째 숫자를 받음 // fristnum을 땡겨와서 num1 매핑시킴.
	//@RequestParam("firstNum")int num1  if) num1(인자)과 fristNum 이름이 동일하면. =>  int firstNum 으로만 사용이 가능
	public ModelAndView process(@RequestParam("firstNum") int num1, 
			int secondNum, @RequestParam("operator") String operator) {
		
		//사용자가 보내준 데이터를 받아야 함.
		//@RequestParam("")을 이용해서 받아요 (String도  포함해서 primitive type인 경우) (vo형태 아닌 것들)
		
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		if(operator.equals("div") && secondNum == 0 ) {
			// 나눗셈을 하는 데 분모가 0 임 => 값은 무한대 개념이 없음  => Exception 
			viewName ="sample02/errorResult";
			mav.addObject("msg","0으로 나눌 수 없어요."); 
		} else {
			int result = 0;
			if(operator.equals("plus")){
				result = num1 + secondNum;
			}else if(operator.equals("minus")){
				result = num1 - secondNum;
			}else if(operator.equals("mul")){
				result = num1 * secondNum;
			}else {
				result = num1 / secondNum;
			}
			viewName ="sample02/calcResult";
			mav.addObject("msg", result); // msg라는 키값으로 result을 전달.
			// 위에 키와 value는 우리가 알고 있는 request에 전달.
		}
		mav.setViewName(viewName); //내가 사용할 view 객체이름을 명시하여 해당 jsp을 찾아가라.
		return mav;
	}
}
