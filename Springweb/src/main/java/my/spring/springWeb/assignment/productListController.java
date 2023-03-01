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

import my.spring.springWeb.assignment.vo.Product;

@Controller
@SessionAttributes(value= {"Apple","Banana","Halabong"})
public class productListController {
	
	Logger log = LogManager.getLogger("case3");
	
	@ModelAttribute("Apple")
	public Product createProduct1() {
		log.debug("createProduct() 수행");
		
		Product product = new Product();
		product.setProductName("Apple");
		return product;

		
	}
	
	@ModelAttribute("Banana")
	public Product createProduct2() {
		log.debug("createProduct() 수행");
		
		Product product = new Product();
		product.setProductName("Banana");
		
		return product;
	}
	
	@ModelAttribute("Halabong")
	public Product createProduct3() {
		log.debug("createProduct() 수행");
		
		Product product = new Product();
		product.setProductName("Halabong");
		return product;
	}
	
	
	@GetMapping(value="product")
	@Qualifier()
	public String addProcess1(@RequestParam(value="productName") String productName, 
			@ModelAttribute("Apple") Product Apple, @ModelAttribute("Banana") Product Banana
			,@ModelAttribute("Halabong") Product halabong) {
		
		log.debug(productName); // 선택한 과일 이름
		
		if(productName.equals("Apple")) {
			Apple.setProductCount();
		}else if(productName.equals("Banana")) {
			Banana.setProductCount();
		}else if(productName.equals("Halabong")) {
			halabong.setProductCount();
		}
		
		return "assignment/productView";
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
