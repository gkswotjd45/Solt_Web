package my.spring.springWeb.sample06.service;


import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import my.spring.springWeb.sample06.dao.LottoDao;
import my.spring.springWeb.sample06.vo.Lotto;

// bean으로 등록 // 이 bean이 어떤 상태인지 확인 해야하므로. @service 형태로 지정하는 것이 나음.
//@Component

//  Root WebApplicationContext 으로 등록 됨 . 
@Service
public class LottoService {
	Logger log = LogManager.getLogger("case3");
	//lottodao bean을 찾아 필드에 주입.
//	@Autowired
//	@Resource(name="lottoDao")
	
	@Autowired
	@Qualifier(value="lottoDao")
	private LottoDao dao;
	
	public LottoService() {
		// TODO Auto-generated constructor stub
	}
	
	// 로또 당첨 여부를 체크하는 서비스 메서드 생성
	public boolean checkLottoNumber(Lotto lotto) {
		//일반적인 로직처리를 진행할 꺼임.
		// 또 데이터베이스도 처리하겠죠. dao가 필요함.
		boolean result = false;// 당첨 여부
		int randomNumber = dao.selectLottoNumber();// dao을 이용해서 당첨번호를 알아오기.
		
		log.debug("내가 선택한 로또 번호 : "+ lotto.getLottoNum());
		log.debug("로또 당첨 번호 : "+ randomNumber);
		if(randomNumber == lotto.getLottoNum()) {
			result = true;
		}
		return  result ;
	}
}
