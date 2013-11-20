package org.nhnnext.web;

import java.util.Collections;
import java.util.List;

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
		session.removeAttribute("errorMsg");
		if (session.getAttribute("login_Status") == null) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		if (session.getAttribute("login_Status") == login_Status_Off) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		return "potopotophoto_main";
	}
	
	@RequestMapping("/{userEmail}")
	public String loginUserHome(@PathVariable String userEmail, HttpSession session) {
		session.removeAttribute("errorMsg");
		if (session.getAttribute("login_Status") == null) {
			session.setAttribute("login_Status", login_Status_Off);
			return "welcome";
		}
		User curUser = userRepository.findOne(userEmail);
		// reverse list to show boards descending order
		List<Board> boardList = boardRepository.findByUser(curUser);
		Collections.reverse(boardList);
		
		session.setAttribute("userBoards", boardList);
		return "potopotophoto_main";
	}
}

