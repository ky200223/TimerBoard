package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 1000, nullable = false)
	private String reply;

	@ManyToOne
	private Board board;

	public Comment() {
	}

	public Comment(Board board, String reply) {
		this.board = board;
		this.reply = reply;
	}

	public Board getBoard() {
		return board;
	}
}
