package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
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

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	// @RequestMapping(value = "", method = RequestMethod.POST)
	// public String create(String title, String imageContent) {
	// System.out.println("title: " + title + " image: " + imageContent);
	// return "redirect:/";
	// }

	// @RequestMapping(value = "", method = RequestMethod.POST)
	// public String create(Board board) {
	// System.out.println("Board : " + board);
	// return "redirect:/";
	// }

	// @RequestMapping(value = "", method = RequestMethod.POST)
	// public String create(Board board) {
	// Board savedBoard = boardRepository.save(board);
	// return "redirect:/board/" + savedBoard.getId();
	// }

	@RequestMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Board board = boardRepository.findOne(id);
		model.addAttribute("board", board);
		return "show";
		// TODO DB에서 id에 해당하는 Board 데이터를 조회해야 한다.
		// TODO 조회한 Board 데이터를 Model에 저장해야 한다. return "show";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String create(Board board, MultipartFile file) {
		FileUploader.upload(file);
		board.setFileName(file.getOriginalFilename());
		// TODO FileUploader API를 활용해 업로드한 파일을 복사한다.
		// TODO 첨부한 이미지 정보를 데이터베이스에 추가한다.
		Board savedBoard = boardRepository.save(board);
		return "redirect:/board/" + savedBoard.getId();
	}
	
//	@RequestMapping(value = "/search", method = RequestMethod.POST)
//	public String search(@PathVariable Long id, Model model, String title) {
//		id = (long) 1;
//		while(boardRepository.findOne(id).getFileName() != title) {
//			id ++;
//		}
//		
//		return result;
//	}
	
	@RequestMapping(value = "/modifyThrow/{id}", method = RequestMethod.POST)
	public String modifyThrow(@PathVariable Long id, Model model) {
		Board changeBoard = boardRepository.findOne(id);
		model.addAttribute("board", changeBoard);
		return "modify"; //redirect는 get 방식이다! 
	}

	@RequestMapping(value = "/modifySubmit/{id}", method = RequestMethod.POST)
	public String modify(@PathVariable Long id, Board board, MultipartFile file) {
		 Board modifyBoard = boardRepository.findOne(id);
         modifyBoard.setTitle(board.getTitle());
         modifyBoard.setContents(board.getContents());
         
         if (file != null) {
                 FileUploader.upload(file);
                 modifyBoard.setFileName(file.getOriginalFilename());
         }    
         
         boardRepository.save(modifyBoard);         
         return "redirect:/board/" + modifyBoard.getId();
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String delete(@PathVariable Long id) {
		boardRepository.delete(id);
		return "deleteMessage";
    }
}
