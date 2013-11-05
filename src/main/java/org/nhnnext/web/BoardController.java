package org.nhnnext.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.nhnnext.repository.UserRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	public String loginRequired = "로그인이 필요합니다.";

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Board board = boardRepository.findOne(id);
		model.addAttribute("board", board);
		return "show";
		// TODO DB에서 id에 해당하는 Board 데이터를 조회해야 한다.
		// TODO 조회한 Board 데이터를 Model에 저장해야 한다. return "show";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String create(Board board, MultipartFile file, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute("login_Status") == "0") {
			request.setAttribute("errorMsg", loginRequired);
			return "defaultLogin";
		} else {
			if (!file.isEmpty()) {
				FileUploader.upload(file);
				board.setFileName(file.getOriginalFilename());
			}
			String userEmail = (String) session.getAttribute("userEmail");
			User curUser = userRepository.findOne(userEmail);
			board.setUser(curUser);
			// TODO FileUploader API를 활용해 업로드한 파일을 복사한다.
			// TODO 첨부한 이미지 정보를 데이터베이스에 추가한다.
			boardRepository.save(board);
			return "redirect:" + board.getId();
		}
	}

	// @RequestMapping(value = "/search", method = RequestMethod.POST)
	// public String search(@PathVariable Long id, Model model, String title) {
	// id = (long) 1;
	// while(boardRepository.findOne(id).getFileName() != title) {
	// id ++;
	// }
	//
	// return result;
	// }

	@RequestMapping(value = "/modifyThrow/{id}", method = RequestMethod.POST)
	public String modifyThrow(@PathVariable Long id, Model model) {
		Board changeBoard = boardRepository.findOne(id);
		model.addAttribute("board", changeBoard);
		return "modify"; // redirect는 get 방식이다!
	}

	@RequestMapping(value = "/modifySubmit/{id}", method = RequestMethod.POST)
	public String modify(@PathVariable Long id, Board board,
			MultipartFile file, Model model) {
		Board modifyBoard = boardRepository.findOne(id);
		modifyBoard.setTitle(board.getTitle());
		modifyBoard.setContents(board.getContents());

		if (!file.isEmpty()) {
			FileUploader.upload(file);
			modifyBoard.setFileName(file.getOriginalFilename());
		}

		boardRepository.save(modifyBoard);
		model.addAttribute("board", modifyBoard);
		return "modifyMessage";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Long id, HttpSession session) {
		boardRepository.delete(id);
		String userEmail = (String)session.getAttribute("userEmail");
		System.out.println("=============delete============");
		return "redirect:/" + userEmail;
	}
}
