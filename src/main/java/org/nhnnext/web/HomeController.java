package org.nhnnext.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public String login_Status_Off = "0";	
	
	@RequestMapping("/")
	public String index(HttpSession session) {	
		if (session.getAttribute("login_Status") == null)
			session.setAttribute("login_Status", login_Status_Off);
//		return "home";
		return "Home_working";
	}
	
	@RequestMapping("/{userEmail}")
	public String loginUserHome(@PathVariable String userEmail, HttpSession session) {	
		if (session.getAttribute("login_Status") == null)
			session.setAttribute("login_Status", login_Status_Off);
//		return "home";
		return "Home_working";
	}
}

