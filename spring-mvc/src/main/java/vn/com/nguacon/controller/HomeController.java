package vn.com.nguacon.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/home")
	public String openHomePage() {
		log.info("Load Home Page");
		return "home";
	}
}
