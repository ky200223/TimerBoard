package org.nhnnext.web;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String login_Status_Off = "0";	
	
	@RequestMapping("/")
	public String welcome(HttpSession session) {	
		if (session.getAttribute("login_Status") == null)
			session.setAttribute("login_Status", login_Status_Off);
//		return "home";
		return "Home_working";
	}
	
	@RequestMapping("/{userEmail}")
	public String loginUserHome(@PathVariable String userEmail, HttpSession session) {	
		if (session.getAttribute("login_Status") == null)
			session.setAttribute("login_Status", login_Status_Off);
		User curUser = userRepository.findOne(userEmail);
		session.setAttribute("userBoards", boardRepository.findByUser(curUser));
//		return "home";
		return "redirect:/";
	}
}

