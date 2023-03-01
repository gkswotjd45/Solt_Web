package my.spring.springWeb.sample06.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lotto {
	private int lottoNum; // 로또 번호 
	private String result;// 당첨 여부
	
	
}
