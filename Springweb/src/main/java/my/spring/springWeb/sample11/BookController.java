package my.spring.springWeb.sample11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.spring.springWeb.sample11.dao.BookDao;

@Controller
@RequestMapping(value="book")
public class BookController {
	Logger log = LogManager.getLogger("case3");
	@Autowired
	private BookDao dao;
	
	@GetMapping(value="count")
	public String method1(Model model) {
		model.addAttribute("result",dao.getBookCount());
		
		return "sample11/bookCount";
	}
	
	@GetMapping(value="all")
	public String method2(Model model) {
		
		model.addAttribute("result",dao.getAllBooks());
		return "sample11/bookAllList";
	}
	
	@PostMapping(value="search")
	public String method3(Model model, @RequestParam(value="keyword") String keyword) {
		log.debug(keyword);
		model.addAttribute("result",dao.getSearchBooks(keyword));
		return "sample11/bookSearch";
	}
	
}
