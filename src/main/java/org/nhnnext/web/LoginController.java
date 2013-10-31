package org.nhnnext.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nhnnext.repository.UserRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserRepository userRepository;

	public String login_NoEmailExistError = "존재하지 않는 사용자 입니다.";
	public String login_PasswordNotCorrectError = "비밀번호가 옳지 않습니다.";
	public String signUp_AlreadyExistEmailError = "사용중인 이메일입니다. 다른 이메일로 가입해주세요";
	public String signUp_Complete = "회원가입되었습니다. 다시 로그인해주세요";
	
	public String login_Status_On = "1";
	public String login_Status_Off = "0";

	@RequestMapping("/form")
	public String login() {
		return "defaultLogin";
	}

	@RequestMapping("/register")
	public String register() {
		return "userSignUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(User user, HttpSession session, MultipartFile file) {
		if (userRepository.exists(user.getUserEmail())) {
			session.setAttribute("errorMsg", signUp_AlreadyExistEmailError);
			return "redirect:/";
		} else {
			FileUploader.upload(file);
			user.setProfileName(file.getOriginalFilename());
			User registerUser = userRepository.save(user);
			session.setAttribute("errorMsg", signUp_Complete);
			return "redirect:/" + registerUser.getUserEmail();
		}
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String login(String userEmail, String password, HttpSession session, HttpServletRequest request) {
		session.setAttribute("login_Status", login_Status_Off);
		//String referer = request.getHeader("Referer");
		
		if (!userRepository.exists(userEmail)) {
			request.setAttribute("errorMsg", login_NoEmailExistError);
			System.out.println("email_Err");
			return "redirect:/";
		}

		User curUser = userRepository.findOne(userEmail);
		String correctPassword = curUser.getPassword();

		if (correctPassword.equals(password)) {
			session.setAttribute("nickName", curUser.getNickName());
			session.setAttribute("login_Status", login_Status_On);
			session.setAttribute("user", curUser);
			System.out.println("Success");
			return "redirect:/" + curUser.getUserEmail();
		}

		else {
			request.setAttribute("errorMsg", login_PasswordNotCorrectError);
			System.out.println("password_Err");
			return "redirect:/";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("nickName");
		session.removeAttribute("user");
		session.setAttribute("login_Status", login_Status_Off);
		return "redirect:/";
	}
}
