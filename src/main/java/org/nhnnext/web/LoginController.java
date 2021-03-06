package org.nhnnext.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nhnnext.repository.UserRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String signUp(User user, HttpSession session, HttpServletRequest request, MultipartFile file) {
		if (userRepository.exists(user.getUserEmail())) {
			session.removeAttribute("errorMsg");
			session.setAttribute("errorMsg", signUp_AlreadyExistEmailError);
			//System.out.println("email_exist_err");
			return "welcome";
		} else {
			FileUploader.upload(file);
			user.setProfilePicName(file.getOriginalFilename());
			userRepository.save(user);
			//request.setAttribute("errorMsg", signUp_Complete);
			session.removeAttribute("errorMsg");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String login(String userEmail, String password, HttpSession session, HttpServletRequest request) {
		session.setAttribute("login_Status", login_Status_Off);
		
		if (!userRepository.exists(userEmail)) {
			session.removeAttribute("errorMsg");
			session.setAttribute("errorMsg", login_NoEmailExistError);
			return "welcome";
		}

		User curUser = userRepository.findOne(userEmail);
		String correctPassword = curUser.getPassword();

		if (correctPassword.equals(password)) {
			// Remember session's attributes
			session.removeAttribute("errorMsg");
			session.setAttribute("userEmail", curUser.getUserEmail());
			session.setAttribute("nickName", curUser.getNickName());
			session.setAttribute("login_Status", login_Status_On);
			session.setAttribute("user", curUser);
			System.out.println("-----------------------LOGIN_SUCCESS----------------------------------");
			return "redirect:/" + curUser.getUserEmail();
		}

		else {
			session.removeAttribute("errorMsg");
			session.setAttribute("errorMsg", login_PasswordNotCorrectError);
			return "welcome";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("nickName");
		session.removeAttribute("login_Status");
		session.setAttribute("login_Status", login_Status_Off);
		return "redirect:/";
	}
}
