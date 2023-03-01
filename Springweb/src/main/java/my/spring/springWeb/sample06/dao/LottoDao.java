package my.spring.springWeb.sample06.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

//데이터 베이스를 처리하는 bean
@Repository("lottoDao")
public class LottoDao {
	
	public LottoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int selectLottoNumber() {
		Random rand = new Random();
		return rand.nextInt(6)+1; // 1 ~ 6 까지 정수형 난수를 발생.
	}
}
