package my.spring.springWeb.assignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springWeb.assignment.vo.FruitBasket;
import my.spring.springWeb.assignment.vo.Product;

@Controller
@SessionAttributes(value= {"FruitInfo"})
public class FruitListController {
	
	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("FruitInfo")
	public FruitBasket createProduct1() {
		log.debug("createProduct() 수행");
		
		FruitBasket fruitBasket = new FruitBasket();
		
		return fruitBasket;
	}
	
	@GetMapping(value ="Fruit")
	public String addProcess1(@RequestParam(value="productName") String productName,@ModelAttribute("FruitInfo") FruitBasket fruitBasket ) {
		
		log.debug(productName); // 선택한 과일 이름
		if(productName.equals("Apple")) {
			fruitBasket.setAppleCount();
		}else if(productName.equals("Banana")) {
			fruitBasket.setBananaCount();
		}else if(productName.equals("Halabong")) {
			fruitBasket.setHalabongCount();
		}
		
		return "assignment/FruitView";
	}

	@PostMapping(value="fruitList")
	public String allList(@ModelAttribute("FruitInfo") FruitBasket fruitBasket,
			SessionStatus sessionStatus) {
		log.debug(fruitBasket);
		sessionStatus.setComplete();
	
		return "assignment/FruitView";
	}
		
}

//@Controller
//@SessionAttributes(value= {"productInfo"})
//public class productListController {
//	
//	Logger log = LogManager.getLogger("case3");
//	
//	@ModelAttribute("productInfo")
//	public Product createProduct() {
//		log.debug("createProduct() 수행");
//		
//		Product product = new Product();
//		
//		return product;
//		
//	}
//	
//	@GetMapping(value="product")
//	@Qualifier()
//	public String addProcess1(@RequestParam(value="productName") String productName,@ModelAttribute("productInfo") Product productInfo) {
//		
//		
//		log.debug(productName); // 선택한 과일 이름
//		
//		
//		if(productName.equals("Apple")) {
//			productInfo.setProductName(productName);
//			productInfo.setProductCount();
//		}else if(productName.equals("Banana")) {
//			productInfo.setProductName(productName);
//			productInfo.setProductCount();
//		}else if(productName.equals("halabong")) {
//			productInfo.setProductName(productName);
//			productInfo.setProductCount();
//		}
//		
//		
//		return "assignment/productView";
//	}
//
//		
//}
