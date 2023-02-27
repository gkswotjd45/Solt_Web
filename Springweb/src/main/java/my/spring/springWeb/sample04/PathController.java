package my.spring.springWeb.sample04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	//name 과 number에 어떤 값들이 들어와도 requestmapping이 알아서 처리  // 자원에 대한 url 자체의 정보를 이용할 때 pathVariable 형태로 수행.
	@RequestMapping(value="/characher/detail/{name}/{number}")
	public String myMethod1(@PathVariable("name") String name, @PathVariable("number") int num, Model model) {
		//@PathVariable 경로에 대한 변수를 받도록 인자 형태. (cf) queryString은 아님) 
		
		if(name.equals("kakao")) {
			if(num==1) {
				model.addAttribute("imgname","ryan");
			}else if (num==2){
				model.addAttribute("imgname","apeach");
			}else if (num==3) {
				model.addAttribute("imgname","frodoneo");
			}
		}
		if(name.equals("line")) {
			if(num==1) {
				model.addAttribute("imgname","brown");
			}else if (num==2){
				model.addAttribute("imgname","james");
			}else if (num==3) {
				model.addAttribute("imgname","cony");
			}
		}
		
		return "sample04/detailView";
	}
}
