package org.nhnnext.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@Controller
public class HomeController {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String login_Status_Off = "0";	
	
	@RequestMapping("/")
	public String welcome(HttpSession session) {	
		if (session.getAttribute("login_Status") == null) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		if (session.getAttribute("login_Status") == login_Status_Off) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		return "Home_working";
	}
	
	@RequestMapping("/{userEmail}")
	public String loginUserHome(@PathVariable String userEmail, HttpSession session) {	
		if (session.getAttribute("login_Status") == null) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		User curUser = userRepository.findOne(userEmail);
		session.setAttribute("userBoards", boardRepository.findByUser(curUser));
		return "Home_working";
	}
}

