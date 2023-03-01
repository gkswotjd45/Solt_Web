package my.spring.springWeb.sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import my.spring.springWeb.sample06.service.LottoService;
import my.spring.springWeb.sample06.vo.Lotto;


// 컨트롤러 역할.
@Controller
public class LottoController {
	// 그 bean을 찾아서 갇다 붙임. (싱글톤 방식)
	@Autowired
	private LottoService service;
	@GetMapping(value="/lotto") //ModelAttribute Model 객체 Lotto을 통해 수행. // 데이터를 받을 때 쿼리스트링으로 가지고 있는 가지고 있는 key값이 vo에 setter로 값을 밀어 넣어서 수행. 
	//public String lotoProcess(@ModelAttribute Lotto lotto){
	public String lotoProcess(Lotto lotto){
		// 서비스 객체를 만들어서 로직을 처리해야 함.
		// 이방식 문제정은 클라이언트가 여러명이 종시 접속할 때마다 로또 서비스를 개속 생성 => 서비스 객체는 stateless (객체 안에 특정 데이터를 저장하지 않는 형태) => 클라이언트가 들어올 때마다 만들 필요없이 공유해서 사용하는 것이 나음
		// 클라이언트 1명당 1개의 서비스가 아닌  서비스를 bean으로 등록해야 함.
//		LottoService service = new LottoService();
		
		
		// bean이 해당 service을 찾아서 갇다 삽입(주입)해서 사용하는  방식.
		boolean result =  service.checkLottoNumber(lotto);
		if(result) {
			lotto.setResult("당첨되었습니다. 행복시작 ");
			
		}else {
			lotto.setResult("될리 없음");
		}
		return "sample06/lottoView";
	}
}
