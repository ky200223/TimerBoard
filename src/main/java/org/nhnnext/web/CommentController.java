package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public String comment(@PathVariable Long id, String reply) {
		Board board = boardRepository.findOne(id);
		
		Comment comment = new Comment(board, reply);
		commentRepository.save(comment);
		
		return "redirect:/board/" + id;
	}	
}