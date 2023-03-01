package my.spring.springWeb.assignment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Getter @Setter
	private String productName; // 상품이름
	private int productCount = 0; //상품 수요 개수
	
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount() {
		
		this.productCount++;
	}

	
	
}
