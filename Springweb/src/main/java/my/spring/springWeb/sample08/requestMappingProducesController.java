package my.spring.springWeb.sample08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import my.spring.springWeb.common.ApplicationContextProvider;

@Controller
public class requestMappingProducesController {
	

	Logger log = LogManager.getLogger("case3");
	
//	@Autowired
//	private Gson gson; // 만들어진 bean 객체를 자동주입 형태로 등록.
//	
	//get 방식
	@RequestMapping(value="testProduces1")
	public String method01(Model model) {
		model.addAttribute("msg", "소리없는아우성");
		
		return "sample08/requestMappingProducesView";
	}
	
	// produces 제가 끝까지 클라이언트에게 가는 것이 아님 => 어차피 jsp으로 넘어가기 때문에. 
//	@RequestMapping(value="testProduces2",produces = "text/plain; charset=utf-8")
	@RequestMapping(value="testProduces2",produces = "application/json; charset=utf-8")
	public String method02(Model model) {
		model.addAttribute("msg", "소리없는아우성");
		return "sample08/requestMappingProducesView";
	}
	
	// 여기에서 나가는 형태는 "text/html; charset=utf-8" 임 // jsp을 이용하지 않고 컨트롤러에서 stream형태로 직접 결과를 보내줌.
	// 이것은 단순히 지정만 형태고 실제로는 나가는 형태는 별도로 지정해야 함.
	//결과론. 이것은 response body와 상관없이 내가 직접 stream out으로 보내는 것이기 때문에 따로 type을 지정해야함.
	@RequestMapping(value="testProduces3",produces = "text/html; charset=utf-8")
	public void method03(HttpServletResponse response) {
		//response 객체도 application context가 들어 있어 주입이 가능.
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head></head>");
			out.print("<body><h1>소리없는 아우성!</h1></body></html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="testProduces4",produces = "application/json; charset=utf-8")
	public void method04(HttpServletResponse response) {
		//response 객체도 application context가 들어 있어 주입이 가능.
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스트림 열어서
			
			// 데이터를 만듬
			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", "홍길동");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
			// 이 데이터를 json 문자열로 변형해야 함. 
			// gson은 무상태 data 이므로 편하고 쉽게 이용하기 위해서 bean으로 등록.
			// bean을 수동으로 등록해야 함. 
			
//			Gson gson = new Gson(); // 이 객체를 이용해서 tojson을 통해 쉽게 json 변환수행.
			
//			String str = gson.toJson(map); gson필드를  autowired을 통해 등록하여 적용시킨다.
			
			// 수동으로 bean을 만들어 getBean()을 등록
			ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			Gson gson = ctx.getBean("getGson",Gson.class);
			String str = gson.toJson(map); 
			
			
			// 그리고 나서 stream을 통해 클라이언트에게 보내주면 돼요.
			out.println(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
