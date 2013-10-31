package org.nhnnext.web;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100, nullable = false)
	private String title;

	@Column(length = 5000, nullable = false)
	private String contents;

	@Column(length = 1000, nullable = false)
	private String fileName;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	@ManyToOne
	private User user;
	
	public Board() {		
	}
	
	public Board(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", contents" + contents + ", fileName"
				+ fileName + "]";
	}

	public Long getId() {
		return id;
	}

	public List<Comment> getComments() {
		return comments;
	}
}
