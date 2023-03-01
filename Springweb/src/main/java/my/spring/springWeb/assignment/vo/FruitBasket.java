package my.spring.springWeb.assignment.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FruitBasket {
	
	
	@Getter @Setter
	private String Apple;
	@Getter @Setter
	private String Banana;
	@Getter @Setter
	private String Halabong;
	
	private int AppleCount;
	private int BananaCount;
	private int HalabongCount;
	
	
	public int getAppleCount() {
		return AppleCount;
	}
	public void setAppleCount() {
		AppleCount++;
	}
	public int getBananaCount() {
		return BananaCount;
	}
	public void setBananaCount() {
		BananaCount++;
	}
	public int getHalabongCount() {
		return HalabongCount;
	}
	public void setHalabongCount() {
		HalabongCount++;
	}
}
